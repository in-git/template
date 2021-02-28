package com.zzsoftware.module.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzsoftware.module.test.entity.AccApportion;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @author author
 * @since 2021-02-27
 */
@Mapper
@Repository
public interface AccApportionMapper extends BaseMapper<AccApportion> {
	public String getAll();
}
