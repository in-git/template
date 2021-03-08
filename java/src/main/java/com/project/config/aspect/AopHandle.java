package com.project.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

@Component
@Aspect
public class AopHandle{

    /*** *******
     功能说明
     1.统一pointcut 类
     2.捕捉请求api
     ******* */
    @Before("com.project.config.aspect.Pointcut.target()")
    public void before(JoinPoint joinPoint) throws IllegalAccessException, InstantiationException{
        Object[] args=joinPoint.getArgs();
        for(Object index : args){
            System.out.println(index);
        }
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        //入参
        String ip=request.getServerName() + ":" + request.getServerPort();//IP地址
        String requestURI=(request).getRequestURI();//请求相对路径:{ /project/get }
        String url=request.getScheme() + "://" + ip + requestURI;//请求全路径:{ http://127.0.0.1:4000/project/get }
        String headInfo=request.getHeader("LoginInfo"); // 头信息:{null}
        String contextPath=request.getContextPath();//请求项目路径:{ /project }
    }
}
