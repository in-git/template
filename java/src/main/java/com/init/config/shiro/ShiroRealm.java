package com.init.config.shiro;

import java.util.ArrayList;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.init.module.index.bean.Users;
import com.init.module.index.mapper.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	UserDao userDao;
	
	//加密控制

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(3);
		super.setCredentialsMatcher(matcher);
	}

	/*
	 * 功能:给用户授权 注意:授权是在验证之后进行的
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {

		String username = (String) token.getPrimaryPrincipal();

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (!StringUtils.isEmpty("")) {
//            List<String> strings = permsMapper.selectPerms(username);
			info.addStringPermissions(new ArrayList<>());
		}

		return info;
	}

	/*
	 * 功能:验证用户账号密码
	 *
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();

		QueryWrapper<Users> qw = new QueryWrapper<>();
		qw.eq("username", username);
		Users user = userDao.selectOne(qw);
		if (StringUtils.isEmpty(user)) {
			throw new UnknownAccountException();
		}
//		输入从数据库中得到的密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()),
				this.getName());
	}

}
