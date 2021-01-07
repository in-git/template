package com.zzsoft.utils.genreator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
	public static void main(String[] args) {
		// 创建代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOpen(false);
		// 输出目录
//		gc.setOutputDir("E:\\Project\\Java\\ymmall\\src\\main\\java\\com\\zzsoft\\ymmall\\common\\order\\bean");
		gc.setOutputDir("C:\\Users\\Administrator\\Desktop\\Tmp\\database");
		gc.setFileOverride(true); // 是否覆盖已有文件
		gc.setBaseResultMap(false); // XML是否需要BaseResultMap
//		gc.setBaseColumnList(true); // XML是否显示字段
//		gc.setControllerName("%sController");
//		gc.setServiceName("%sService");
//		gc.setServiceImplName("%sServiceImpl");
//		gc.setMapperName("%sMapper");
//		gc.setXmlName("%sMapper");
		gc.setAuthor("author");
		gc.setIdType(IdType.AUTO);
		mpg.setGlobalConfig(gc);
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.SQL_SERVER);
		dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dsc.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=SMB6Comp07");
		dsc.setUsername("test");
		dsc.setPassword("admin1234");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig sc = new StrategyConfig();
//		sc.setTablePrefix("tab_"); // 表名前缀
		sc.setNaming(NamingStrategy.underline_to_camel); // 表名生成策略
		sc.setEntityBuilderModel(true);
		sc.setEntityLombokModel(true);
		sc.setInclude("ordBillFrom");
		mpg.setStrategy(sc);
// 		包配置
		PackageConfig pc = new PackageConfig();
//		将会生成包
		pc.setParent("./");
		pc.setEntity("bean");
//		pc.setController("controller");
//		pc.setService("service");
//		pc.setServiceImpl("serviceImpl");
//		pc.setMapper("mapper");
//		pc.setXml("mapper");
		mpg.setPackageInfo(pc);
		
		
		// 指定模板引擎 默认velocity
		TemplateConfig templateConfig = new TemplateConfig();

		// 控制 不生成 controller
		templateConfig.setController("");
		templateConfig.setMapper(null);
		templateConfig.setServiceImpl(null);
		mpg.setTemplate(templateConfig);
		
		mpg.execute();
	}

}
