package com.zzsoftware.config.plugin;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Configuration
public class MybatisConfig implements MetaObjectHandler {
	// 功能:Mybatis分页配置
	// @Bean
//	 public PageHelper pageHelper() {
//	 PageHelper pageHelper = new PageHelper();
//	 Properties p = new Properties();
//	 p.setProperty("offsetAsPageNum", "true");
//	 p.setProperty("rowBoundsWithCount", "true");
//	 p.setProperty("reasonable", "true");
//	 pageHelper.setProperties(p);
//	 return pageHelper;
//	 }



	@Override
	public void insertFill(final MetaObject metaObject) {
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}

	@Override
	public void updateFill(final MetaObject metaObject) {
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}

}
