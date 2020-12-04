package com.init.index.module.index.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.init.index.global.utils.common.Tools;
import com.init.index.module.index.mapper.Dao;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


@org.springframework.stereotype.Service

@Slf4j
public class Service {

    @Autowired
    Dao mapper;
    /*
     * 用户登录配置
     * */

    public void login(Object user, String rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        //        开启记住我
        UsernamePasswordToken token = new UsernamePasswordToken("username", "passwd", rememberMe);
        try {
            subject.login(token);
        } catch (Exception ex) {
            log.error("登录失败");
        }

    }

    /*
     * 功能:用户注册加密，并存储到数据库中
     * */
    public void register(Object user) {
//        从数据库查询User数据
        if (StringUtils.isEmpty("user")) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            String key = Tools.getId();
//            user.setUkey(key);
//            String password = user.getPasswd();
            String ciphertext = new Md5Hash("password", "salt", 3).toString();
//            user.setSalt(String.valueOf(salt));
//            user.setPasswd(ciphertext);//设置密码
//            mapper.insert(user);  //添加到数据库
        }
    }
}
