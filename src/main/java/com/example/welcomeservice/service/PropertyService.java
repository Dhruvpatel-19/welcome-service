package com.example.welcomeservice.service;

import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    public Property getProperty(int id){
        Optional<Property> property = propertyRepository.findById(id);

        if(property.isPresent()){
            return property.get();
        }
        else{
            return null;
        }
    }
}
