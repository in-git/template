package com.init.config.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Slf4j
public class WebInterceptor implements HandlerInterceptor {

    /*
     * 功能:截取用户请求，统计用户访问量
     * */
    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response , Object handler) {
        return true;
    }
}
