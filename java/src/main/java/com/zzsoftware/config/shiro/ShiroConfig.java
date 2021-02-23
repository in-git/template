package com.zzsoftware.config.shiro;

//  需要单独导入这个包，否则报错

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//  必须配置该注解,默认关闭
@Component
public class ShiroConfig {
	

// 常用拦截器	anon , authc ,perms, port ,rest ,roles , ssl ,user
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
		shiro.setSecurityManager(securityManager);
		Map<String, String> filter = new LinkedHashMap<String, String>();
		filter.put("/public/**", "anon");
		filter.put("/order/**", "anon");
		filter.put("/**", "anon");

		shiro.setFilterChainDefinitionMap(filter);
//		设置登陆路径
		shiro.setLoginUrl("/");
		return shiro;
	}

	@Bean
	public ShiroRealm getUserRealm() {
		return new ShiroRealm();
	}

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private String port;

	// 配置 RedisManager ,用于与底层Redis交互
	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		return redisManager;
	}

	// 配置SessionDao ，用于控制 RedisManager
	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		redisSessionDAO.setSessionIdGenerator(new CustomSessionIdGenerator());
		return redisSessionDAO;
	}

	@Bean
	public CacheManager shiroRedisCacheManager() {
		return new RedisCacheManager();
	}

	/**
	 * 配置 回话管理器 ，用于存储 token状态
	 */
	@Bean
	public DefaultSessionManager sessionManager() {
		CustomSessionManager manager = new CustomSessionManager();
		manager.setSessionDAO(redisSessionDAO());
		manager.setSessionIdCookieEnabled(false);
		manager.setSessionValidationSchedulerEnabled(false);
		// 禁用url 重写 url; shiro请求时默认 jsessionId=id
		manager.setSessionIdUrlRewritingEnabled(false);
		return manager;
	}

	// 开启缓存
	@Bean
	public RedisCacheManager redisCacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setRedisManager(redisManager());
		return redisCacheManager;
	}

	// 配置核心安全管理器:将自定义管理器注册到安全管理器
	@Bean
	public SecurityManager securityManager(ShiroRealm shiroRealm) {
		// 一定要注意是 : DefaultWebSecurityManager
		DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm);

		securityManager.setSessionManager(sessionManager());
		// 将自定义的Redis缓存管理器注册到安全管理器中
		securityManager.setCacheManager(redisCacheManager());
		return securityManager;
	}

	/**
	 * 开启aop注解支持
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类
	 * 需要配置以下两个Bean
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
}
