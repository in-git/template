package com.zzsoftware.module.home.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzsoftware.module.home.bean.Test;
import com.zzsoftware.module.home.dao.TestDao;

@Service
public class MyService {
	@Autowired
	TestDao testDao;
	public List<Test> select() {
		return testDao.selectList(null);
	}
}
