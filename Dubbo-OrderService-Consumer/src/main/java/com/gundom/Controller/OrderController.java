package com.gundom.Controller;

import com.gundom.Domain.User;
import com.gundom.Service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Reference
    UserService userService;

    @ResponseBody
    @RequestMapping("/dubboOrder")
    public List<User> OrderText(@RequestParam("userId") String userId){
        System.out.println(userId);
        List<User> users = userService.queryByRange();

        return users;
    }
    @ResponseBody
    @RequestMapping("/order")
    public User OrderText01(@RequestParam("userId") int userId){
        System.out.println(userId);
        User users = userService.queryByOne();

        return users;
    }
}
