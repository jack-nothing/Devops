package com.kechun.quartz.staticQ;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Monitor {


    @Scheduled(cron = "59 59 59 * * ? ")
    public void moveTmpData(){

        System.out.println(System.currentTimeMillis());

    }


}