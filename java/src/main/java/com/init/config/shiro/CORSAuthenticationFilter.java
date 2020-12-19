package com.company.config.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
* 功能:过滤试探请求 
*/
public class CORSAuthenticationFilter extends FormAuthenticationFilter {

	private static final String REQUET_TYPE = "OPTIONS";

	public CORSAuthenticationFilter() {
		super();
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (((HttpServletRequest) request).getMethod().toUpperCase().equals(REQUET_TYPE)) {
			return true;
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse res = (HttpServletResponse) response;
		return false;
	}
}
