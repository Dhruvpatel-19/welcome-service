package com.example.welcomeservice.controller;

import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/callWelcomeService/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
