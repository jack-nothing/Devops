package com.kechun.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kechun.conf.ContentSet;
import com.kechun.entity.SysUser;
import com.kechun.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getUserPageList/{userId}")
    public ContentSet getUserList(@PathVariable("userId") Integer userId){
        IPage<SysUser> page = new Page<>(1, 20);
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        page = sysUserService.selectPage(page, qw);
        System.out.println(page.getRecords());
        return ContentSet.getContentSet(200,page,"操作成功");
    }



    @PostMapping("/addUser")
    public ContentSet addUser(){

        return ContentSet.getContentSet(200,"","操作成功");
    }

    @PostMapping("/deleteUser")
    public ContentSet deleteUser(){


        return ContentSet.getContentSet(200,"","操作成功");
    }
    @PostMapping("/updateUser")
    public ContentSet updateUser(){


        return ContentSet.getContentSet(200,"","操作成功");
    }

    @GetMapping("/getUser/{userId}")
    public ContentSet getUser(@PathVariable("userId") Integer userId){


        return ContentSet.getContentSet(200,"","操作成功");
    }

}