package com.kechun.controller;


import com.kechun.conf.ContentSet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {



    @PostMapping("/login")
    public ContentSet login(String email,String password){



        return ContentSet.getContentSet(200,"","登录成功");
    }




}