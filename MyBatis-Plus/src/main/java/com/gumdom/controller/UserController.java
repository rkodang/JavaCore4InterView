package com.gumdom.controller;

import com.gumdom.pojo.NewUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid NewUser user){

        return "success";
    }
}
