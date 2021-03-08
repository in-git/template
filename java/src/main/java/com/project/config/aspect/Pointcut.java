package com.project.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Pointcut{
    @org.aspectj.lang.annotation.Pointcut("execution(public * com.project.module.web..*.*(..))")
    public void target(){}
}
