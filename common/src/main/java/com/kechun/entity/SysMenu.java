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
@TableName("t_sys_menu")
public class SysMenu extends Model<SysUser>{

    @TableId(value = "menuId",type = IdType.AUTO)
    private Integer menuId;

    @TableField("menuName")
    private String menuName;
    @TableField("url")
    private String url;
    @TableField("lastUpdateTime")
    private String lastUpdateTime;
    @TableField("parentId")
    private Integer  parentId;


    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }



}