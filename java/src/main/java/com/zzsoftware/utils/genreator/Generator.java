package com.zzsoftware.utils.genreator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {
	static AutoGenerator mpg = new AutoGenerator();
	static GlobalConfig gc = new GlobalConfig();
	public static void main(String[] args) {
		/**
		 * ->项目根路径
		 * 需要修改
		 */
		String projectPath = "E:\\Project\\Java\\zz-salary";
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("author");
		gc.setOpen(false);
		gc.setFileOverride(false);
		gc.setIdType(IdType.AUTO);
		gc.setDateType(DateType.ONLY_DATE);
		gc.setServiceName("%sService");
		mpg.setGlobalConfig(gc);

		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=SMB6Comp07");
		dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dsc.setUsername("test");
		dsc.setPassword("admin1234");
		mpg.setDataSource(dsc);

		PackageConfig pc = new PackageConfig();

		pc.setParent("com.zzsoftware.module");
		/**
		 * ->模块名
		 * 此处需要修改
		 */
		pc.setModuleName("module name");
		pc.setEntity("entity");
		pc.setMapper("mapper");
		pc.setService("service");
		pc.setController("controller");
		mpg.setPackageInfo(pc);

		StrategyConfig strategy = new StrategyConfig();
		/**
		 * ->表名
		 * 此处需要修改
		 */
		strategy.setInclude("accApportion");
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.execute();
	}
}
