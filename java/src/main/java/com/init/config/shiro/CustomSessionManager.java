package com.company.config.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomSessionManager extends DefaultWebSessionManager {
	final private static String AUTHORIZATION = "authToken";
//	final private static String AUTHORIZATION = "id";

	final private static String REFERENCED_SESSION_ID_SOURCE = "header";

	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		// 获取请求头中的authToken
		String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		if (StringUtils.isEmpty(id)) {
			return super.getSessionId(request, response);
		} else {
			// 如果请求头中有 authToken 则其值为sessionId
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			return id;
		}
	}
}