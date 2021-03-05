package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.project")
@MapperScan(basePackages = {"com.project.module"})
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}