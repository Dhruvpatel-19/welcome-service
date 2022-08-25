package com.example.welcomeservice.service;

import com.example.welcomeservice.entity.Property;
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
        return propertyRepository.findAll();
    }
}
