package com.gundom.Service;

import com.gundom.Domain.User;
import org.apache.dubbo.config.annotation.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public User initOrder(String userId) {

        System.out.println(userId);
        return new User("DubboGet",2,5);
    }
}
