package com.gundom.Controller;

import com.gundom.Domain.User;
import com.gundom.Service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference()
    OrderService orderService;
    @ResponseBody
    @RequestMapping("/dubboUser")
    public User queryById(int userId){
        System.out.println(userId);
        User user = orderService.initOrder(userId + "");
        System.out.println(user);
        return user;
    }
    @ResponseBody
    @RequestMapping("/user")
    public List<User> queryByRange(){
        List<User> users = orderService.queryByRange();
        return users;
    }
}
