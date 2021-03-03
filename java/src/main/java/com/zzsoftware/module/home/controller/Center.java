package com.zzsoftware.module.home.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Center {
    @GetMapping("get")
    public String get() {
        return "test";
    }
}
