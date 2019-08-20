package com.kechun.quartz.staticQ;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Monitor {

    //每分钟循环分发任务
//    @Scheduled(cron = "* 0/1 * * * ? ")


    @Scheduled(cron = "59 59 59 * * ? ")
    public void moveTmpData(){

        System.out.println(System.currentTimeMillis());

    }


}