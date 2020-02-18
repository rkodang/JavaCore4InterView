package com.gundom.Controller;

import com.gundom.Domain.User;
import com.gundom.Service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Reference
    UserService userService;

    @RequestMapping("/dubboOrder")
    public void OrderText(String userId){
        List<User> users = userService.queryByRange();
        System.out.println(users);
        System.out.println(userId);
    }
}
