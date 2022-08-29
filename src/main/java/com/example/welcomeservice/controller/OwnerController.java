package com.example.welcomeservice.controller;

import com.example.welcomeservice.entity.Owner;
import com.example.welcomeservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/callWelcomeService/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping(value = "/register")
    public Owner saveOwner(@RequestBody Owner owner){
        return ownerService.saveOwner(owner);
    }
}
