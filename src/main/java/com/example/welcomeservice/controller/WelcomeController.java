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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/welcomeService/")
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @Operation(summary = "Get All Favourite Property From User Favourite List",description = "This method is used to get all the favourite property of the user", tags = {"WelcomeController"})
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Reteived all property successfully"),
      @ApiResponse(responseCode = "400",description = "Bad Request"),
      @ApiResponse(responseCode = "404",description = "Property not found"),
      @ApiResponse(responseCode = "403",description = "Forbidden")
    })
    @GetMapping(value = "/getAllProperty")
    public List<AllPropertyDTO> getAllProperty(){
        return welcomeService.getAllProperty();
    }


    @Operation(summary = "Buy the property",description = "This method is used to buy a particular property by the user.", tags = {"WelcomeController"})
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Brought the property successfully"),
      @ApiResponse(responseCode = "400",description = "Bad Request"),
      @ApiResponse(responseCode = "404",description = "Property not found"),
      @ApiResponse(responseCode = "403",description = "Forbidden")
    })
    @GetMapping(value = "/buyProperty/{id}")
    public String buyProperty(HttpServletRequest request ,  @PathVariable("id") int id) throws Exception {
        return welcomeService.buyProperty(request, id);
    }

}
