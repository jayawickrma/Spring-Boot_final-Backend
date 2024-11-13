package com.example.demo.Service.IMPL;

import com.example.demo.DTO.IMPL.userDTO;
import com.example.demo.Secure.JWTAuthResponse;
import com.example.demo.Secure.SignIn;
import com.example.demo.Service.AuthService;

public class AuthServiceIMPL implements AuthService {

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(userDTO userDTO) {
        return null;
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
        return null;
    }
}
