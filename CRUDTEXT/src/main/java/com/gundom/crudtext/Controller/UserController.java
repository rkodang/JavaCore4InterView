package com.gundom.crudtext.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/hi")
    public String sayHi(){
        return "js";
    }

    @ResponseBody
    @RequestMapping("/user/registy")
    public String get(@Param("username") String username, @Param("password") String password){
        System.out.println(username+"/"+password);
        return username+password;
    }
}
