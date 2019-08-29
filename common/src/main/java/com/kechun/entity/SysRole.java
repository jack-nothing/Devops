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
@TableName("t_sys_role")
public class SysRole extends Model<SysUser> {

    @TableId(value = "roleId",type = IdType.AUTO)
    private Integer roleId;
    @TableField("roleName")
    private String roleName;
    @TableField("enableStatus")
    private Integer enableStatus;
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}