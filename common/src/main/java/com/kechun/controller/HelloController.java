package com.kechun.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin("*")
public class HelloController {


    @RequestMapping("/demo")
    public String demo(){

        return "ok";
    }



    public static String test(){
        System.out.println(123);
        return "123456";
    }
}