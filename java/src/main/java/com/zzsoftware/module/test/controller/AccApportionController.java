package com.zzsoftware.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzsoftware.config.redis.RedisUtil;
import com.zzsoftware.module.test.service.impl.AccApportionServiceImpl;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author author
 * @since 2021-02-27
 */

@RestController
@RequestMapping("/test/acc-apportion")
public class AccApportionController {
	@Autowired
	AccApportionServiceImpl accApportionService;
	@GetMapping("getAll")
	public Object getAll() {
		return accApportionService.getAll();
	}
	@Autowired
	RedisUtil jedis;
	@GetMapping("redisHset")
	public void hset() {
		jedis.hset("h", "username", "Jhone");
	}
}
