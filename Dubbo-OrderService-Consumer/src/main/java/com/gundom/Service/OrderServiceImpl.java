package com.gundom.Service;

import com.gundom.Domain.User;
import org.apache.dubbo.config.annotation.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public User initOrder(String userId) {
        return new User("DubboGet",2,5);
    }


    @Override
    public List<User> queryByRange() {
        List<User> userList=new LinkedList<User>();
        userList.add(new User("DubboGet",2,5));
        userList.add(new User("DubboGet",3,6));
        userList.add(new User("DubboGet",4,7));
        return userList;
    }
}
