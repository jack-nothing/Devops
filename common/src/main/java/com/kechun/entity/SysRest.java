package com.kechun.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors
@TableName("t_sys_rest")
public class SysRest extends Model<SysUser> {

    @TableId(value = "restId",type = IdType.AUTO)
    private Integer restId;

    @TableField("restUrl")
    private String restUrl;

    @TableField("restName")
    private String restName;

    @Override
    protected Serializable pkVal() {
        return this.restId;
    }
}