package com.revature.controllers;

import java.util.ArrayList;

import com.revature.data.User;
import com.revature.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
// @RequestMapping("User")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/register")
    public ArrayList<User> register(@RequestBody User user) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(userRepository.postUser(user));
        return list;
    }

    // @RequestMapping("/login")
    // public ArrayList<User> login(@RequestBody User user) {
    // ArrayList<User> list = new ArrayList<User>();
    // list.add(userRepository.authenticate(user.getUsername(),
    // user.getPassword()));
    // return list;
    // }

    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        User un = userRepository.authenticate(user.getUsername(), user.getPassword());
        System.out.println(un);
        return un;
    }

    @RequestMapping("/update")
    public User update(@RequestBody User user) {
        userRepository.updateGuestSession(user);
        return user;
    }

}