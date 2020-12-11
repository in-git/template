package com.init.config.shiro;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        super.setCredentialsMatcher(matcher);
    }

    /*
     * 功能:给用户授权
     * 注意:授权是在验证之后进行的
     * */
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
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        if (StringUtils.isEmpty("")) {

            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(username, "password", ByteSource.Util.bytes("salt"), this.getName());
    }


}
