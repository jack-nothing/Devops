package com.kechun.quartz.staticQ;


import com.kechun.conf.EventType;
import com.kechun.conf.Event;
import com.kechun.conf.threadpool.ThreadPoolManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Monitor {

    static ThreadPoolManager tm = new ThreadPoolManager(16);

    //每分钟循环分发任务
    @Scheduled(cron = "* 0/1 * * * ? ")
    public void quartz(){
        tm.addExecuteTask(new Event(EventType.MINUTES_MONITOR_EVENT));

        tm.addExecuteTask(new Event(EventType.HOURS_MONITOR_EVENT));

    }


}