package com.company.config.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
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
        	System.out.println(ex.toString());
            log.warn("用户权限校验失败");
        }
    }

    @Override
    public void destroy() {
        log.warn("destroy");
    }
}
