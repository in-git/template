package com.init.index.module.index.action;

import com.init.index.bean.Users;
import com.init.index.global.attribute.result.ResultInfo;
import org.springframework.validation.annotation.Validated;

/*
 * 功能:统一行为管理
 * */
public interface Action {
    ResultInfo login ( @Validated Users user , String remeberMe );
    ResultInfo register ( @Validated Users user );

}
