package com.kechun.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin("*")
public class HelloController {
//    @Value("${keyspaceApp:@null}")

    @RequestMapping(value = "/demo",method = {RequestMethod.GET,RequestMethod.POST})
    public String demo(){

        return "ok";
    }



    public static String test(){
        System.out.println(123);
        return "123456";
    }
}