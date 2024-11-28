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
import java.util.Optional;

@Service

public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username).
                        orElseThrow(()->new UserNotFoundException("User Name Not Found"));
    }

    @Override
    public boolean sendCodeToChangePassword(UserWithKey userWithKey) {
        Optional<UserEntity>byEmail=userDao.findByEmail((userWithKey.getEmail()));
        if (byEmail.isPresent()){
            return true;
        }
        return false;
    }
}
