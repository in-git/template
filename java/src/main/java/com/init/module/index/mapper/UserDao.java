package com.init.module.index.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.module.index.bean.Users;


/*
 *   说明:非Class类型
 *       以驼峰命名
 *       对应类型的小写字母放首位
 *   ex:
 *       接口类型:iInterface
 *       枚举类型:eEnum
 *       Annotation:aAnnotation
 * */
@Repository
@Mapper
public interface UserDao extends BaseMapper<Users> {}
