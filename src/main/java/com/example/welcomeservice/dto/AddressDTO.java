package com.example.welcomeservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressDTO {

    private String streetLine;
    private String additionalStreet;
    private String city;
    private String state;
    private int postCode;

}
