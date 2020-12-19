package com.company.config.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;


public class WebInterceptor implements HandlerInterceptor {
	final private static String AUTHORIZATION = "authToken";

	/*
	 * 功能:验证token
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String token = request.getHeader("authToken");
//		校验Token,为空或校验成功则放行
//		boolean isLogin = JwtUtil.verify(token);
//		return isLogin || StringUtils.isEmpty(token) ? true : false;
		
		return true;
	}
}
