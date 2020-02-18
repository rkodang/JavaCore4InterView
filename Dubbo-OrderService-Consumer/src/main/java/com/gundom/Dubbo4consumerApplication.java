package com.gundom;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Dubbo4consumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dubbo4consumerApplication.class, args);
    }

}
