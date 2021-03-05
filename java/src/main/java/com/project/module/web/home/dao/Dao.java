package com.project.module.web.home.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Dao {
    @Select("select 2")
    String getInfo();
}
