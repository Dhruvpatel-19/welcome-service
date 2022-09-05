package com.example.welcomeservice.service;

import com.example.welcomeservice.Exception.Handler.UserNotFoundException;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User>  findAllUser(){
        if(userRepository.findAll().isEmpty()) throw new UserNotFoundException();

        return userRepository.findAll();
    }

    public User updateUser(int id , User updatedUser){
        User user = userRepository.findById(id).orElse(null);
        if(userRepository.findById(id)==null)throw new UserNotFoundException();
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setMobileNumber(updatedUser.getMobileNumber());

        userRepository.save(user);
        return user;
    }
}
