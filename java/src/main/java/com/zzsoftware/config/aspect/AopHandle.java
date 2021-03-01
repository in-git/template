package com.zzsoftware.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// @Component
//@Aspect
public class AopHandle {
    @Before("execution(* com.zzsoftware.module..*(..))")
    public void before() throws Throwable {
        System.out.println("执行");
    }
}
