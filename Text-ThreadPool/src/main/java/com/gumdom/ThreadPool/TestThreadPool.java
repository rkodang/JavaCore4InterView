package com.gumdom.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestThreadPool {


    public static void main(String[] args) {
        ExecutorService threadpool= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {

            threadpool.submit(()->{
                System.out.println("currentName"+Thread.currentThread().getName());

                try {
                    Object object =null;
                    System.out.println("result**"+object.toString());
                } catch (Exception e) {
                    System.out.println("异常来了"+e);
                }

            });



        }
    }
}
