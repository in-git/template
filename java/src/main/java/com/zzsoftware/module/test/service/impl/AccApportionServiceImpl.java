package com.zzsoftware.module.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzsoftware.module.test.entity.AccApportion;
import com.zzsoftware.module.test.mapper.AccApportionMapper;
import com.zzsoftware.module.test.service.AccApportionService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2021-02-27
 */
@Service
public class AccApportionServiceImpl extends ServiceImpl<AccApportionMapper, AccApportion>
		implements AccApportionService {
	@Autowired
	AccApportionMapper acc;
	@Override
	public String getAll() {
		return acc.getAll();
	}

}
