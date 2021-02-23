package com.zzsoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.init")
@MapperScan("com.init")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class , args);
    }
}
