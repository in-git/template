package com.init.index.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.init.index.bean.Users;
import com.init.index.module.user.mapper.iPermsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        super.setCredentialsMatcher(matcher);
    }

    @Autowired
    com.init.index.mapper.iUserMapper iUserMapper;

    @Autowired
    iPermsMapper permsMapper;
    /*
     * 功能:给用户授权
     * 注意:授权是在验证之后进行的
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {

        String username = (String)token.getPrimaryPrincipal();
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = iUserMapper.selectOne(wrapper);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(!StringUtils.isEmpty(user)){
            List<String> strings = permsMapper.selectPerms(username);
            info.addStringPermissions(strings);
        }

        return info;
    }

    /*
     * 功能:验证用户账号密码
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        Users user = iUserMapper.selectOne(wrapper);
        if(StringUtils.isEmpty(user)){

            throw new UnknownAccountException();
        }
        String salt = user.getSalt();
        return new SimpleAuthenticationInfo(username, user.getPasswd(), ByteSource.Util.bytes(salt), this.getName());
    }


}
