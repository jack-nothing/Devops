package com.kechun.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@CrossOrigin("*")
public class DemoController {

    @RequestMapping("demo")
    public String test3(){
        return "fdfs-ok";
    }
}