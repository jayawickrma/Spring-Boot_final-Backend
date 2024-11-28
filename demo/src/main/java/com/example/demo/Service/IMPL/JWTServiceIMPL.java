package com.example.demo.Service.IMPL;

import com.example.demo.DAO.UserDao;
import com.example.demo.Service.JWTService;
import com.example.demo.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTServiceIMPL implements JWTService {


    @Override
    public String extractUserName(String token) {
        return null;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public String refreshToken(UserDetails userDetails) {
        return null;
    }
}
