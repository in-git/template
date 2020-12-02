package com.init.index.config.plugin;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    /*
   功能:
         在多线程中注入mapper
         在websocket中注入mapper
   使用方法:
         Redis bean = SpringContextUtil.getBean( Redis.class );
   注意:
         只能在方法中注入
 */
    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext ( ApplicationContext applicationContext ) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext ( ) {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     */
    public static Object getBean ( String name ) {
        return getApplicationContext( ).getBean( name );
    }

    /**
     * 通过class获取Bean.
     */
    public static < T > T getBean ( Class < T > clazz ) {
        return getApplicationContext( ).getBean( clazz );
    }

    /**
     * 功能:通过name,以及Clazz返回指定的Bean
     * 参数:
     * name:Bean的名字
     * clazz:Bean的类
     */
    public static < T > T getBean ( String name , Class < T > clazz ) {
        return getApplicationContext( ).getBean( name , clazz );
    }
}