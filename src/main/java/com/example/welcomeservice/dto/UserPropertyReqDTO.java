package com.example.welcomeservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPropertyReqDTO {
    private UserDTO user;
    private PropertyDTO property;
}
