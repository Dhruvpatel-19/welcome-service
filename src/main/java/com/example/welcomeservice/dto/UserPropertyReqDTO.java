package com.example.welcomeservice.dto;

import com.example.welcomeservice.entity.UserReqProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPropertyReqDTO {
    private UserDTO user;
    private PropertyDTO property;
}
