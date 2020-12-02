package com.init.index.config.shiro;

//  需要单独导入这个包，否则报错

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.LinkedHashMap;
import java.util.Map;

//  必须配置该注解,默认关闭
@Component
public class ShiroConfig {

    //  创建ShiroFilterFactoryBean
    @Bean ( name = "shiroFilterFactoryBean" )
    public ShiroFilterFactoryBean getShiroFilterFactoryBean ( @Qualifier ( "defaultWebSecurityManager" ) DefaultWebSecurityManager defaultWebSecurityManager ) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean( );
        shiroFilterFactoryBean.setSecurityManager( defaultWebSecurityManager );
        Map < String, String > prevent = new LinkedHashMap <>( );

        /*
            拦截配置:   anon,authc,authcBasic,perms,port,rest,roles,ssl,user
            说明:
                    /public/**      public下所有文件所有用户均可以访问
                    /user/**        user下所有文件均为权限拦截
                    其他路径        所有文件均为权限拦截
        */

        prevent.put( "/" , "anon" );                                              //    首页
        prevent.put( "/websocket/**" , "anon" );                                     //    websocket
        prevent.put( "/public/**" , "anon" );                                     //    公共页面
        prevent.put( "/user/logout" , "logout" );                                 //    退出
        prevent.put( "/user/**" , "user" );                                       //    登录用户页面
        prevent.put( "/error/**" , "anon" );                                      //    错误页面
        prevent.put( "/**" , "authc" );                                           //    一定要写在最下面，拦截所有权限

        /*   返回拦截页面   */
        shiroFilterFactoryBean.setLoginUrl( "/" );                                //    登录拦截返回页面
        shiroFilterFactoryBean.setUnauthorizedUrl( "/public/error/403.html" );    //    授权拦截返回页面
        shiroFilterFactoryBean.setSuccessUrl( "/user/user.html" );                //    登录成功需要访问的页面
        shiroFilterFactoryBean.setFilterChainDefinitionMap( prevent );
        return shiroFilterFactoryBean;
    }

    @Bean ( name = "defaultWebSecurityManager" )
    //  创建DefaultWebSecurityManager
    public DefaultWebSecurityManager getDefaultWebSecurityManager ( @Qualifier ( "realmConfig" ) ShiroRealm realm ) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager( );
        defaultWebSecurityManager.setRealm( realm );
        return defaultWebSecurityManager;
    }
    
    @Bean ( name = "realmConfig" )
    public ShiroRealm getUserRealm ( ) {
        return new ShiroRealm( );
    }

    /**
        功能:开启注解拦截必须配置,如@RequiresRoles,@RequiresPermissions
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator ( ) {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator( );
        advisorAutoProxyCreator.setProxyTargetClass( true );
        return advisorAutoProxyCreator;
    }

    /**
     *  开启aop注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor ( SecurityManager securityManager ) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor( );
        authorizationAttributeSourceAdvisor.setSecurityManager( securityManager );
        return authorizationAttributeSourceAdvisor;
    }
    /*
            #   --------------------------------------------- #
             ------------- 以下为开启记住我的功能 -------------
            #   --------------------------------------------- #
    */

    /**
     * 功能:记住我配置
     */
    @Bean
    public SimpleCookie rememberMeCookie ( ) {
        SimpleCookie simpleCookie = new SimpleCookie( "rememberMe" );
        simpleCookie.setHttpOnly( true );
        simpleCookie.setPath( "/" );
        simpleCookie.setMaxAge( 60 * 60 * 24 * 30 );
        return simpleCookie;
    }

    /**
     * cookie管理对象
     */
    @Value ( "${shiro.key}" )
    String key;

    @Bean
    public CookieRememberMeManager rememberMeManager ( ) {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager( );
        cookieRememberMeManager.setCookie( rememberMeCookie( ) );
        cookieRememberMeManager.setCipherKey( Base64.decode( key ) );
        return cookieRememberMeManager;
    }

    /**
     * 过滤记住我
     */
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter ( ) {
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter( );
        //对应前端的checkbox的name = rememberMe
        formAuthenticationFilter.setRememberMeParam( "rememberMe" );
        return formAuthenticationFilter;
    }


    /**
     * 配置核心安全事务管理器
     */
    @Bean
    public SecurityManager securityManager ( ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager( );
        securityManager.setRealm( new ShiroRealm( ) );
        securityManager.setRememberMeManager( rememberMeManager( ) );
        return securityManager;
    }

}
