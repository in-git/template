package com.project.module.web.home.controller;

import com.project.config.redis.RedisUtil;
import com.project.module.web.home.bean.Bean;
import com.project.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Center{
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("get")
    public String get(String arg){
        return arg.equals(null)? "null":arg;
    }

    //    接收数组参数
    @PostMapping("getArgByBean")
    public Result getArgByBean(@RequestBody Bean[] bean){
        return Result.ok().data("String",bean);
    }

    //    测试redis工具类
    @GetMapping("redis")
    public Object testRedis(){
        return redisUtil.get("test");
    }

}