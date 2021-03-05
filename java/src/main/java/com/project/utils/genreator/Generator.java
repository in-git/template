package com.project.utils.genreator;

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
    /*                           *
     *      这些字段都需要修改   *
     *                           *///
    //  项目配置
    private final static String projectPath = "E:\\Project\\Java\\zz-salary";//用项目根路径
    private final static String parentPackage = "com.zzsoftware.module";//根模块名
    public static final String databaseName = "test";
    private final static String[] tables = new String[]{"tableA"};//表名
    public static final String moduleName = "module";
    //    账户
    private static final String passwd = "00000000";
    private static final String username = "root";
    public static final String author = "author";

    //    ===========
    //    Main 执行
    //    ===========
    public static void main(String[] args) {
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
//        设置为Mysql
        dsc.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=" + databaseName);
        dsc.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dsc.setUsername(username);
        dsc.setPassword(passwd);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();

        pc.setParent(parentPackage);
        pc.setModuleName(moduleName);
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tables);
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
