package com.init.config.shiro;

import java.io.Serializable;
import java.util.UUID;

import com.init.config.redis.Jedis;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *功能:	
 *	自定义SessionID
 *	将该类注册到RedisSessionDao中才生效
 */
public class CustomSessionIdGenerator implements SessionIdGenerator {
	@Autowired 
	Jedis jedis;
	@Override
	public Serializable generateId(Session session) {
		return  UUID.randomUUID().toString().replace("-","");
//		return null;
	}
}