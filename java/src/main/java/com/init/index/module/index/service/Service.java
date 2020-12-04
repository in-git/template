package com.init.index.module.index.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.init.index.bean.Users;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.global.utils.common.Tools;
import com.init.index.mapper.iUserMapper;
import com.init.index.module.index.action.Action;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


/*
 * 功能:统一服务管理,实现Action接口
 * */
@org.springframework.stereotype.Service

@Slf4j
public class Service implements Action {

    @Autowired
    iUserMapper mapper;


    @Override
    public ResultInfo login(Users user , String rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        //        开启记住我
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername() , user.getPasswd() , rememberMe);
        try {
            subject.login(token);
        }
        catch (Exception ex) {
            return new ResultInfo(eStatusSystem.ERROR_SELECT.getStatus() , eStatusSystem.ERROR_SELECT.getMsg() , null);
        }
        return new ResultInfo(eStatusSystem.SUCCESS_SELECT.getStatus() , "登录成功" , null);
    }

    /*
     * 功能:用户注册加密，并存储到数据库中
     * */
    @Override
    public ResultInfo register(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username" , user.getUsername());
        Users users = mapper.selectOne(wrapper);
        if (StringUtils.isEmpty(users)) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            String key = Tools.getId();
            user.setUkey(key);
            String password = user.getPasswd();
            String ciphertext = new Md5Hash(password , salt , 3).toString();
            user.setSalt(String.valueOf(salt));
            user.setPasswd(ciphertext);
            mapper.insert(user);
            return new ResultInfo(eStatusSystem.SUCCESS_INSERT.getStatus() , eStatusSystem.SUCCESS_INSERT.getMsg() , null);
        }
        return new ResultInfo(eStatusSystem.ERROR_INSERT.getStatus() , "添加失败" , null);
    }
}
