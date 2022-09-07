package com.example.welcomeservice.repository;

import com.example.welcomeservice.entity.Property;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.entity.UserReqProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReqPropertyRepository extends JpaRepository<UserReqProperty , Integer> {
    boolean existsByUserAndProperty(User user, Property property);
}
