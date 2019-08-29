package com.kechun.conf;
public class Event implements Runnable{


    private EventType eventType;



    public Event(EventType eventType){
        this.eventType=eventType;
    }


    @Override
    public void run() {
        System.out.println(eventType);
        if(EventType.MINUTES_MONITOR_EVENT.equals(eventType)){
            //判断当前时间点是不是到执行的点


        }else if(EventType.HOURS_MONITOR_EVENT.equals(eventType)){
            //判断当前时间点是不是执行的点

        }


    }



}