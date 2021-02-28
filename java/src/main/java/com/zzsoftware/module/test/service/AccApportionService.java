package com.zzsoftware.module.test.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzsoftware.module.test.entity.AccApportion;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2021-02-27
 */
@Service
public interface AccApportionService extends IService<AccApportion> {
	public String getAll();
}
