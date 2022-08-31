package com.example.welcomeservice.service;

import com.example.welcomeservice.dto.AddressDTO;
import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.entity.Address;
import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.jwt.JwtUtil;
import com.example.welcomeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WelcomeService {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyService.getAllProperty();
        return propertyList.stream().map(this::toAllPropertyDTO).collect(Collectors.toList());
    }

    public String buyProperty(HttpServletRequest request, int propertyid) throws Exception {

        Property property = propertyService.getProperty(propertyid);

        /*if(property == null)
            throw new Exception("Property doesn't exist");*/

        if(property == null)
            return "Property doesn't exists";

        if(property.isSold())
            return "Property already bought";

        property.setSold(true);

        String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String email = null;
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

            try{
                email = jwtUtil.extractUsername(jwtToken);

            }catch (Exception e){
                throw new Exception("User not found exception");
            }

            User user = userRepository.findByEmail(email);
            List<Property> userPropertyList = user.getPropertyList();
            userPropertyList.add(property);
            userRepository.save(user);
            return "Property bought successfully";
        }
        return "Some error occured for buyProperty ";
    }

    private AllPropertyDTO toAllPropertyDTO(Property property){

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
