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
@TableName("t_sys_user")
public class SysUser extends Model<SysUser> {

    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;

    @TableField("nickName")
    private String nickName;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @TableField("password")
    private String password;
    @TableField("enableStatus")
    private Integer enableStatus;
    @TableField("level")
    private Integer level;
    @TableField("lastUpdateTime")
    private String lastUpdateTime;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}