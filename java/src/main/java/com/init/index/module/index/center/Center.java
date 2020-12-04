package com.init.index.module.index.center;
import com.init.index.bean.Users;
import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.module.index.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("public")
@Controller
@Slf4j
public class Center {
    @Autowired
    Service service;


    /*
     * 功能:登录
     * */
    @ResponseBody
    @GetMapping("login")
    public ResultInfo login(@Validated Users user,@RequestParam(defaultValue = "true") String rememberMe) {
        return service.login(user,rememberMe);
    }

    /*
     * 功能:注册
     * */
    @ResponseBody
    @GetMapping("register")
    public ResultInfo register(@Validated Users user) {

        return service.register(user);
    }
}
