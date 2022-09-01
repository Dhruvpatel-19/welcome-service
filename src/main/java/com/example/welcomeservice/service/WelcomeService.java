package com.example.welcomeservice.service;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.entity.Address;
import com.example.welcomeservice.entity.Owner;
import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.jwt.JwtUtil;
import com.example.welcomeservice.repository.OwnerRepository;
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
    private OwnerRepository ownerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyService.getAllProperty();
        return propertyList.stream().map(this::toAllPropertyDTO).collect(Collectors.toList());
    }

    public String buyProperty(HttpServletRequest request, int propertyid) throws Exception {

        Property property = propertyService.getProperty(propertyid);

        if(property == null)
            return "Property doesn't exists";

        if(property.isSold())
            return "Property already bought";

        User user = (User) getOwnerOrUser(request);
        if(user!=null){
            List<Property> userPropertyList = user.getPropertyList();
            property.setSold(true);
            userPropertyList.add(property);
            userRepository.save(user);
            return "Property bought successfully";
        }
        return "Some error occured for buyProperty ";
    }

    private AllPropertyDTO toAllPropertyDTO(Property property){

        AllPropertyDTO allPropertyDTO = new AllPropertyDTO();

        allPropertyDTO.setPropertyId(property.getPropertyId());
        allPropertyDTO.setPropertyName(property.getPropertyName());
        allPropertyDTO.setPrice(property.getPrice());
        allPropertyDTO.setArea(property.getArea());
        allPropertyDTO.setImage(property.getImages().get(0).getImage());
        allPropertyDTO.setAddress(property.getAddress());

        return allPropertyDTO;
    }

    private Object getOwnerOrUser(HttpServletRequest request) throws Exception {
        String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String email = null;

        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try {
                email = jwtUtil.extractUsername(jwtToken);
            }catch (Exception e){
                throw new Exception("User not found");
            }

            User user = userRepository.findByEmail(email);
            Owner owner = ownerRepository.findByEmail(email);
            if(user!=null)
                return user;
            else
                return owner;
        }
        return null;
    }

}
