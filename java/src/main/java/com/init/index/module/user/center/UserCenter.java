package com.init.index.module.user.center;

import com.init.index.global.attribute.result.ResultInfo;
import com.init.index.global.attribute.result.eStatusSystem;
import com.init.index.module.user.mapper.iPermsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * 功能:
 *   1.用户管理中心
 *   2.开启shiro后，需要一定权限才能访问该类
 * */
@Controller
@Slf4j
@RequestMapping("user")
public class UserCenter {
    /*
     * 功能:对某项功能进行添加操作
     * */
    @Autowired
    iPermsMapper permsMapper;

    @ResponseBody
    @RequiresPermissions("admin:add")
    @RequestMapping("add")
    public ResultInfo add() {
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        System.out.println(username);
        List<String> strings = permsMapper.selectPerms(username);
        return new ResultInfo(eStatusSystem.SUCCESS_INSERT.getStatus() , eStatusSystem.SUCCESS_INSERT.getMsg(),strings );
    }

    /*
        功能:用户退出
    * */

}
