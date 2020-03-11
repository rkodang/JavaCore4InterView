package com.gumdom.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class ServiceForThreadPoolText {
    private static Logger logger = LogManager.getLogger(ServiceForThreadPoolText.class.getName());
    @Async("getExecutorGD")
    public void get01(){
        logger.info("线程-"+Thread.currentThread().getId()+"执行写入");
        System.out.println("线程01执行中");
    }

    @Async("getExecutorGD")
    public void get02(){
        logger.info("线程-"+Thread.currentThread().getId()+"执行写入");
        System.out.println("线程02执行中");
    }

    @Async("getExecutorGD")
    public Future<String> execute(String username){
        logger.info("线程-"+Thread.currentThread().getId()+"执行写入");
        return  new AsyncResult<>(username);
    }

}
