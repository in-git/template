package com.init.index.config.plugin;

import com.github.pagehelper.PageHelper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.Properties;

@Configuration
public class BeanConfig {
    //    功能:Mybatis分页配置
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum" , "true");
        p.setProperty("rowBoundsWithCount" , "true");
        p.setProperty("reasonable" , "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
    @Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();
    }
}
