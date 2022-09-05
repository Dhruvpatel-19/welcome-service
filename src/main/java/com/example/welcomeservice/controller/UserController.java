package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.UserDTO;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/callWelcomeService/user")
public class UserController {

    @Autowired
    private UserService userService;



    @Operation(summary = "Create user",description = "This method is used to create User", tags = {"UserController"})
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "User Created"),
      @ApiResponse(responseCode = "400",description = "Bad Request"),
      @ApiResponse(responseCode = "404",description = "Property not found"),
      @ApiResponse(responseCode = "403",description = "Forbidden")
    })
    @PostMapping(value = "/register")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }



    @Operation(summary = "Find All User",description = "This method is used to get all the User", tags = {"UserController"})
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found all users"),
      @ApiResponse(responseCode = "400",description = "Bad Request"),
      @ApiResponse(responseCode = "404",description = "Property not found"),
      @ApiResponse(responseCode = "403",description = "Forbidden")
    })
    @GetMapping(value = "/findAll")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }



    @Operation(summary = "Update User",description = "This method is used to update details of the user", tags = {"UserController"})
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Updated the user"),
      @ApiResponse(responseCode = "400",description = "Bad Request"),
      @ApiResponse(responseCode = "404",description = "Property not found"),
      @ApiResponse(responseCode = "403",description = "Forbidden")
    })
    @PutMapping(value = "/update/{id}")
    public UserDTO updateUser(@PathVariable("id") int id ,@RequestBody User updatedUser){
        return userService.updateUser(id,  updatedUser);
    }
}
