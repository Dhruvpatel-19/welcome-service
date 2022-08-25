package com.example.welcomeservice.service;

import com.example.welcomeservice.dto.AddressDTO;
import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.entity.Address;
import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyRepository.findAll();
        return propertyList.stream().map(this::toPropertyDTO).collect(Collectors.toList());
    }

    private AllPropertyDTO toPropertyDTO(Property property){

        AllPropertyDTO allPropertyDTO = new AllPropertyDTO();
        AddressDTO addressDTO = toAddressDTO(property.getAddress());

        allPropertyDTO.setPropertyName(property.getPropertyName());
        allPropertyDTO.setPrice(property.getPrice());
        allPropertyDTO.setArea(property.getArea());
        allPropertyDTO.setImage(property.getImages().get(0).getImage());
        allPropertyDTO.setAddress(addressDTO);

        return allPropertyDTO;
    }

    private AddressDTO toAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreetLine(address.getStreetLine());
        addressDTO.setAdditionalStreet(address.getAdditionalStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPostCode(address.getPostCode());
        return addressDTO;
    }

}
