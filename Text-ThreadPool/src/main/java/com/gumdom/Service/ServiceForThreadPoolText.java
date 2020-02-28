package com.gumdom.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class ServiceForThreadPoolText {
    @Async("getExecutorGD")
    public void get01(){
        System.out.println("线程01执行中");
    }

    @Async("getExecutorGD")
    public void get02(){
        System.out.println("线程02执行中");
    }

    @Async("getExecutorGD")
    public Future<String> execute(String username){
        return  new AsyncResult<>(username);
    }

}
