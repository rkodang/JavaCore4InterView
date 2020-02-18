package com.gundom.Controller;

import com.gundom.Domain.User;
import com.gundom.Service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Reference
    OrderService orderService;

    @RequestMapping("/dubboUser")
    public void queryById(int userId){
        User user = orderService.initOrder(userId + "");
        System.out.println(user);
        System.out.println(userId);
    }
}
