package com.project.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Pointcut{
    //    捕捉 "web" 模块下所有信息
    @org.aspectj.lang.annotation.Pointcut("execution(public * com.project.module.web..*.*(..))")
    public void target(){}
}
