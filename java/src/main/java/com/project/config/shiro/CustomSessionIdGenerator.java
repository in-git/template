package com.project.config.shiro;

import java.io.Serializable;
import java.util.UUID;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;


/**
 *功能:	
 *	自定义SessionID
 *	将该类注册到RedisSessionDao中才生效
 */
public class CustomSessionIdGenerator implements SessionIdGenerator {
	@Override
	public Serializable generateId(Session session) {
		return  UUID.randomUUID().toString().replace("-","");
//		return null;
	}
}