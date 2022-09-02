package com.example.welcomeservice.mapstruct;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.entity.Property;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    AllPropertyDTO propertyToAllPropertyDto(Property property);
}
