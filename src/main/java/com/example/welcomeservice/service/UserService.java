package com.example.welcomeservice.service;

import com.example.welcomeservice.entity.Favourites;
import com.example.welcomeservice.entity.User;
import com.example.welcomeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        Favourites fav = new Favourites();
        fav.setCreatedAt(LocalDateTime.now());
        user.setFavourites(fav);
        return userRepository.save(user);
    }

    public List<User>  findAllUser(){
        return userRepository.findAll();
    }

    public void updateUser(int id , User updatedUser){
        User user = userRepository.findById(id).orElse(null);

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setMobileNumber(updatedUser.getMobileNumber());

        userRepository.save(user);
    }
}
