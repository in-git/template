package com.init.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements AuthenticationToken {
	private static final long serialVersionUID = 1L;

	private String principal;

	private String token;

	@Override
	public String getPrincipal() {
		System.out.println("处理凭证");
		return principal;
	}

	@Override
	public Object getCredentials() {
		return true;
	}
}
