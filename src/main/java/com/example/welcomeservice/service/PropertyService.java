package com.example.welcomeservice.service;

import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.exception.PropertyNotFoundException;
import com.example.welcomeservice.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperty(){

        if(propertyRepository.findAll().isEmpty()) throw new PropertyNotFoundException();

        return propertyRepository.findAll();
    }

    public Property getProperty(int id){
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null)
            throw new PropertyNotFoundException();
        return property;
    }

    public Property saveProperty(Property property){
        return propertyRepository.save(property);
    }

    public List<Property> searchProperty(String query){
        if(propertyRepository.searchProperty(query).isEmpty())
            throw new PropertyNotFoundException();
        return propertyRepository.searchProperty(query);
    }
}
