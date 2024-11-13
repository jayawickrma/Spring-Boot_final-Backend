package com.example.demo.Service.IMPL;

import com.example.demo.DTO.IMPL.userDTO;
import com.example.demo.Service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(userDTO userDTO) {

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, userDTO userDTO) {

    }

    @Override
    public List<userDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }
}
