package com.kechun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("commonServiceClient")
public interface CommonService {


    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public String getUserInfo();

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public String getUserInfoStr();

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info();


}