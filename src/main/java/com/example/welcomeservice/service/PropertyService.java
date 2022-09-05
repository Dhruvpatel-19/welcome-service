package com.example.welcomeservice.service;

import com.example.welcomeservice.Exception.Handler.PropertyNotFoundException;
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

        if(propertyRepository.findAll().isEmpty()) throw new PropertyNotFoundException();

        return propertyRepository.findAll();
    }

    public Property getProperty(int id){
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isPresent()==false) throw new PropertyNotFoundException();
            return property.get();
    }

    public Property saveProperty(Property property){
        return propertyRepository.save(property);
    }
}
