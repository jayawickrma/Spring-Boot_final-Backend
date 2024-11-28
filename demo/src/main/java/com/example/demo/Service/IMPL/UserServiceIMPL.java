package com.example.demo.Service.IMPL;

import com.example.demo.DAO.UserDao;
import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.DTO.IMPL.UserWithKey;
import com.example.demo.Entity.IMPL.UserEntity;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Service.UserService;
import com.example.demo.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;


    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }

    @Override
    public boolean sendCodeToChangePassword(UserWithKey userWithKey) {
        return false;
    }
}
