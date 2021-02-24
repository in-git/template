package com.zzsoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.zzsoftware")
@MapperScan("com.zzsoftware")
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class , args);
    }
}