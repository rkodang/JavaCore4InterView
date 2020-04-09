package com.gumdom.controller;

import com.gumdom.pojo.NewUser;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * GitHub地址：https://github.com/RudeCrab/rude-java/tree/master/project-practice/validation-and-exception-handler
 */


@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 这个方法带有valid验证
     * @param user
     * @return success
     */
    @PostMapping("/adduser")
    public String addUser(@RequestBody @Valid NewUser user){
        System.out.println(user);
        System.out.println("adduser");
        return "success";
    }
}
