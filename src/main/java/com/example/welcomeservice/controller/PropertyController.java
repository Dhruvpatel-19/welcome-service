package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/welcomeService/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllPropertyDTOList(){
        return propertyService.getAllProperty();
    }

}
