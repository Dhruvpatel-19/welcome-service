package com.example.welcomeservice.service;

import com.example.welcomeservice.dto.AllPropertyDTO;
import com.example.welcomeservice.dto.PropertyDTO;
import com.example.welcomeservice.entity.Owner;
import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.exception.*;
import com.example.welcomeservice.jwt.JwtUtil;
import com.example.welcomeservice.mapstruct.MapStructMapper;
import com.example.welcomeservice.repository.OwnerRepository;
import com.example.welcomeservice.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
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
    private MapStructMapper mapStructMapper;

    @Autowired
    private JwtUtil jwtUtil;

    public List<AllPropertyDTO> getAllProperty(){
        List<Property> propertyList = propertyService.getAllProperty();
        if(propertyList.isEmpty()) throw new PropertyNotFoundException();
        return propertyList.stream().map(property -> mapStructMapper.propertyToAllPropertyDto(property)).collect(Collectors.toList());
    }

    public PropertyDTO buyProperty(HttpServletRequest request, int propertyid) throws Exception {

        Property property = propertyService.getProperty(propertyid);


        if(property == null) throw new PropertyNotFoundException();

        if(property.isSold())
            throw new PropertySoldException();

        User user ;
        try {
             user = (User) getOwnerOrUser(request);
        }catch (Exception e){
            user = null;
        }

        if(user == null)
        {
            throw new UserNotFoundException();
        }

        property.setUser(user);
        propertyService.saveProperty(property);

        List<Property> userPropertyList = user.getPropertyList();
        property.setSold(true);
        userPropertyList.add(property);
        userRepository.save(user);
        return mapStructMapper.propertyToPropertyDto(property);
    }

    private Object getOwnerOrUser(HttpServletRequest request){
        String requestTokenHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String email = null;
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

            try{
                email = jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException e){
                throw new JwtTokenExpiredException();
            }catch (SignatureException | MalformedJwtException e){
                throw new JwtSignatureException();
            } catch (Exception e){
                return null;
            }

            User user = userRepository.findByEmail(email);
            Owner owner = ownerRepository.findByEmail(email);

            if(user == null && owner==null)
                throw new UserNotFoundException();
            if(user!=null)
                return user;
            else
                return owner;
        }
        return null;
    }

}
