package com.zzsoftware.module.home.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzsoftware.module.home.bean.Test;
import com.zzsoftware.module.home.service.MyService;
import com.zzsoftware.utils.genreator.Generator;
import com.zzsoftware.utils.genreator.TableNamesDao;

@RestController
@CrossOrigin
public class Center {
	@Autowired
	MyService MyService;
	
	@Autowired
	TableNamesDao tableNamesDao;
	
	@GetMapping("daoTest")
	public List<Test> daoTest() {
		return MyService.select();
	}
	
//	生成代码
	@GetMapping("exec")
	public void exec(String []tableName,String moduleName,String author) {
		Generator.exec(author,moduleName,tableName);
	}
	@GetMapping("findTableNames")
	public List<String> findTableNames() {
		return tableNamesDao.findTableNames();
	}
}
