package com.example.demo2.services.impl;

import com.example.demo2.domain.User;
import com.example.demo2.repositories.UserRepository;
import com.example.demo2.services.UserService;
import com.example.demo2.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long save(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user).getId();
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::userToUserDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    private UserDTO userToUserDTO(User user){
       return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }
}
