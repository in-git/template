package com.project.module.web.home.service;

import com.project.module.web.home.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    Dao dao;

    public String getInfo(){
        return dao.getInfo();
    }
}
