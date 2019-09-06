package com.example.demo2.controllers;

import com.example.demo2.services.UserService;
import com.example.demo2.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserDTO> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/save")
    public Long saveUser(){
        Random rnd = new Random();
        Integer value = rnd.nextInt(100);
        return userService.save(new UserDTO(null, "Test"+value, "Test"+value));
    }
}
