package com.example.welcomeservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AllPropertyDTO {

    private String propertyName;
    private String price;
    private String area;
    private String image;
    private boolean isSold;
    private AddressDTO address;

}
