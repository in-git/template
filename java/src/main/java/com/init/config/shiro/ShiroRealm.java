package com.company.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.company.module.customer.bean.CustomerAccount;
import com.company.module.customer.mapper.MapperCustomer;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	MapperCustomer loginMapper;

//	@Override
//	public boolean supports(AuthenticationToken token) {
//		System.out.println("token = "+ token);
//		// 仅支持StatelessToken类型的Token
//		return token instanceof JwtToken;
//	}

	/*
	 * 功能:给用户授权 注意:授权是在验证之后进行的
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {

		return null;
	}

	/*
	 * 功能:验证用户账号密码
	 *
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		CustomerAccount accounts = loginMapper.selectAccountByMobile(username);
		if (StringUtils.isEmpty(accounts)) {
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(accounts, accounts.getPasswd(), this.getName());
	}

}
