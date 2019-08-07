package com.kechun.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/testcase")
@RestController
@CrossOrigin("*")
public class TestCaseController {


    @RequestMapping("/protal")
    public String test2(){
        return HelloController.test();
    }
}