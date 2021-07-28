package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/users")
    private void createUser(@RequestBody User user)
    {
        userService.save(user);
    }

    @GetMapping("/users/{username}")
    private User getUser(@PathVariable String username)
    {
        return userService.findByUsername(username);
    }

    @GetMapping("/users/all")
    private List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
}
