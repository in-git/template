package com.init.index.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data

public class Users implements Serializable {
    private long id;
    //    解决横向越权问题
    private String ukey;
    @NotNull
    @Size(min = 2, max = 10)
    private String username;
    @NotNull
    @Size(min = 6, max = 20)
    private String passwd;
    private String salt;
    //       黑名单
    private Integer balck;
    //       登录受限
    private Integer restrictd;
}
