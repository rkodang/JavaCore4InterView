package com.gumdom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gumdom.mapper.UserMapper;
import com.gumdom.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hi")
    public List<User> helloController(){
        User user = userMapper.selectById(1);
        List<User> users = userMapper.selectList(null);
        return users;
    }
    @RequestMapping("/hi1")
    public String hihi(){
        User u=new User();
        u.setUserName("测试用");
        userMapper.insert(u);
//        List<Integer> userList=new ArrayList<>();
//        userList.add(8);
//        userList.add(9);
//        userMapper.deleteBatchIds(userList);
        return "ojbk";
    }
    @RequestMapping("/querywrapper")
    public List<User> testEquals(){
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("user_name","测试用");//数据字段名是怎样的就怎样写,不能写成userName

        List<User> users = userMapper.selectList(qw);

//        List<Integer> userList=new ArrayList<>();
//        userList.add(8);
//        userList.add(9);
//        userMapper.deleteBatchIds(userList);
        return users;
    }
}
