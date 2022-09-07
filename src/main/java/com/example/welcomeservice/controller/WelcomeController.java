package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.dto.PropertyDTO;
import com.example.welcomeservice.dto.UserPropertyReqDTO;
import com.example.welcomeservice.service.WelcomeService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get All Favourite Property From User Favourite List",description = "This method is used to get all the favourite property of the user", tags = {"WelcomeController"})
    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return welcomeService.getAllProperty();
    }

    @Operation(summary = "Buy the property Request",description = "This method is used to request to buy a particular property", tags = {"WelcomeController"})
    @GetMapping(value = "/buyPropertyReq/{propertyId}")
    public UserPropertyReqDTO buyPropertyReq(HttpServletRequest request , @PathVariable("propertyId") int id){
        return welcomeService.buyPropertyReq(request , id);
    }

}
