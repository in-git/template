package com.init.index.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class WebFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req , ServletResponse res , FilterChain chain) throws IOException, ServletException {
        /*
        * 功能:在前后端分离项目中，前端会发送options请求试探，使用该过滤器过滤该请求
        * */
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin" , "*");
        response.setHeader(
                "Access-Control-Allow-Methods" ,
                "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age" , "3600");
        response.setHeader(
                "Access-Control-Allow-Headers" ,
                "Content-Type, x-requested-with, X-Custom-Header, Authorization");
        try{
            chain.doFilter(req , res);
        }
        catch (Exception ex){
            log.warn("用户权限校验失败");
        }
    }

    @Override
    public void destroy() {
        log.warn("destroy");
    }
}
