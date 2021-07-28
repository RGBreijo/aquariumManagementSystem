package com.example.aquariummanagementsystem.service;


import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public void save(User user)
    {
        userRepository.save(user);
    }


}
