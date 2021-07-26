package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/users")
    private ResponseEntity<?> createUser(@RequestBody User user)
    {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}")
    private User getUser(@PathVariable String username)
    {
        return userService.findByUsername(username);
    }


}
