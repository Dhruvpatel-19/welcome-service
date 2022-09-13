package com.example.welcomeservice.controller;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.dto.UserPropertyReqDTO;
import com.example.welcomeservice.service.WelcomeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/welcomeService/")
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @Operation(summary = "Get All Favourite Property",description = "This method is used to get all property", tags = {"WelcomeController"})
    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return welcomeService.getAllProperty();
    }

    @Operation(summary = "Buy the property Request",description = "This method is used to request to buy a particular property", tags = {"WelcomeController"})
    @GetMapping(value = "/buyPropertyReq/{propertyId}")
    public UserPropertyReqDTO buyPropertyReq(HttpServletRequest request , @PathVariable("propertyId") int id){
        return welcomeService.buyPropertyReq(request , id);
    }

    @Operation(summary = "Remove Buy Property Request" ,description = "This method is used to remove the request made to buy property")
    @GetMapping(value = "/removePropertyReq/{propertyId}")
    public UserPropertyReqDTO removePropertyReq(HttpServletRequest request , @PathVariable("propertyId") int id){
        return welcomeService.removePropertyReq(request , id);
    }

    @Operation(summary = "Get All Property According To Search",description = "This method is used to get all property relevant to search term", tags = {"WelcomeController"})
    @GetMapping(value = "/search")
    public List<AllPropertyDTO> searchProperty(@RequestParam("query") String query){
        return welcomeService.searchProperty(query);
    }

}
