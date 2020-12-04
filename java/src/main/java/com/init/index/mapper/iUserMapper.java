package com.init.index.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.init.index.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/*
 * 功能:Mapper层，使用MybatisPlus映射数据
 * 注意:已经关闭了驼峰命名，如果出现异常，到配置中修改
 * */
@Repository
@Mapper
public interface iUserMapper extends BaseMapper<Users> {

}
