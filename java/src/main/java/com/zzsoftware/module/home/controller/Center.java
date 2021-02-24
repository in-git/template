package com.zzsoftware.module.home.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzsoftware.module.home.bean.Test;
import com.zzsoftware.module.home.service.MyService;

@RestController
@CrossOrigin
public class Center {
	@Autowired
	MyService MyService;
	@GetMapping("test")
	public String test() {
		System.out.println( "获取" );
		return "test";
	}
	
	@GetMapping("daoTest")
	public List<Test> daoTest() {
		return MyService.select();
	}
}
