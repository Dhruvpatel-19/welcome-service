package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/welcomeService/")
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return welcomeService.getAllProperty();
    }

    @GetMapping(value = "/buyProperty/{id}")
    public String buyProperty(HttpServletRequest request ,  @PathVariable("id") int id) throws Exception {
        return welcomeService.buyProperty(request, id);
    }

}
