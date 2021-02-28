package com.zzsoftware.module.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author author
 * @since 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("accApportion")
public class AccApportion implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Flag", type = IdType.AUTO)
    private Integer Flag;

    @TableField("SubjectID")
    private String SubjectID;

    @TableField("DeptProjID")
    private String DeptProjID;

    @TableField("ApportionRate")
    private Float ApportionRate;

    @TableField("ApportionAmount")
    private BigDecimal ApportionAmount;


}
