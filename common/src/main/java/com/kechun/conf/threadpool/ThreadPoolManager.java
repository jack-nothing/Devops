package com.kechun.conf.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    private LinkedBlockingQueue<Runnable> taskQueue =
            new LinkedBlockingQueue<>();
    private ThreadPoolExecutor threadPool;

    public ThreadPoolManager(int corePoolSize){
        this.threadPool
                = new ThreadPoolExecutor(corePoolSize,corePoolSize,0L, TimeUnit.SECONDS,this.taskQueue);
    }

    public int getQueueSize(){
        return this.taskQueue.size();
    }
    public void addExecuteTask(Runnable command){
        this.threadPool.execute(command);
    }

    public boolean isComplete(){
        return threadPool.getActiveCount() + getQueueSize() == 0;
    }

    public int getAct(){
        return this.threadPool.getActiveCount() + getQueueSize();
    }
}