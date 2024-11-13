package com.example.demo.Service.IMPL;

import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.Service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public class UserServiceIMPL implements UserService {
    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }
}
