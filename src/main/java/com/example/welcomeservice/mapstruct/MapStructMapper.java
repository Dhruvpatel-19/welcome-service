package com.example.welcomeservice.mapstruct;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.dto.PropertyDTO;
import com.example.welcomeservice.dto.UserDTO;
import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    AllPropertyDTO propertyToAllPropertyDto(Property property);
    UserDTO userToUserDto(User user);
    PropertyDTO propertyToPropertyDto(Property property);
}
