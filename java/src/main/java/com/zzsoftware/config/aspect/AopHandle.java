package com.zzsoftware.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// @Component
@Aspect
public class AopHandle {
	@Before("execution(* com.init.index.module..*(..))")
	public void before() throws Throwable {
		System.out.println("执行");
	}
}
