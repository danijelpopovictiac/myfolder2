package com.example.demo2.services;

import com.example.demo2.services.dto.UserDTO;

import java.util.List;

public interface UserService {

    Long save(UserDTO userDTO);

    List<UserDTO> findAll();

}
