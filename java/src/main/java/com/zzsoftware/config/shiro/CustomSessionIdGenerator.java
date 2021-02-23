package com.zzsoftware.config.shiro;

import java.io.Serializable;
import java.util.UUID;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import com.zzsoftware.config.redis.Jedis;


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