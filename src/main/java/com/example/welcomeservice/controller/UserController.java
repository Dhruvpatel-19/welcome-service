package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.UserDTO;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/callWelcomeService/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/findAll")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @PutMapping(value = "/update/{id}")
    public UserDTO updateUser(@PathVariable("id") int id ,@RequestBody User updatedUser){
        return userService.updateUser(id,  updatedUser);
    }
}
