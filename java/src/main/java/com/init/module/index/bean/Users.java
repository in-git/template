package com.init.module.index.bean;

import java.io.Serializable;

import org.crazycake.shiro.AuthCachePrincipal;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@Data
@TableName("user_info")
public class Users implements Serializable ,AuthCachePrincipal {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String salt;
	private Integer id;
	@Override
	public String getAuthCacheKey() {
		return null;
	}

}
