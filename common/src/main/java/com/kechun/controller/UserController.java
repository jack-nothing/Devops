package com.kechun.controller;


import com.kechun.conf.ContentSet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {



    @GetMapping("/getUserList/{userId}")
    public ContentSet getUserList(@PathVariable("userId") Integer userId){


        return ContentSet.getContentSet(200,"","操作成功");
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