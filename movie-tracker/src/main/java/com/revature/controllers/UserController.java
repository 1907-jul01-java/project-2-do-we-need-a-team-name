package com.revature.controllers;

import com.revature.data.User;
import com.revature.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.postUser(user);
    }

    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        return userRepository.authenticate(user.getUsername(), user.getPassword());
    }
}