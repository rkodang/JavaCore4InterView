package com.gundom.Service;

import com.gundom.Domain.User;
import org.apache.dubbo.config.annotation.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> queryByRange() {
        List<User> userList=new LinkedList<User>();
        userList.add(new User("张三",1,15));
        userList.add(new User("李四",2,26));

        return userList;
    }

    @Override
    public User queryByOne() {
        return new User("李四",2,26);
    }
}
