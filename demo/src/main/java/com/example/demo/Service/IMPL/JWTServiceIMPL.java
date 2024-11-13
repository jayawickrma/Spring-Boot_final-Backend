package com.example.demo.Service.IMPL;

import com.example.demo.Service.JWTService;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTServiceIMPL implements JWTService {
    @Override
    public String extractUserName(String token) {
        return null;
    }

    @Override
    public String generateToken(UserDetails user) {
        return null;
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String refreshToken(UserDetails userDetails) {
        return null;
    }
}
