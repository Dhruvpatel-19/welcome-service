package com.example.welcomeservice.repository;

import com.example.welcomeservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    @Query("SELECT p FROM Property p WHERE p.propertyName LIKE CONCAT('%' , ?1 , '%') ")
    List<Property> searchProperty(String query);
}
