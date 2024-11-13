package com.example.demo.Service;

import com.example.demo.DTO.IMPL.userDTO;
import com.example.demo.Secure.JWTAuthResponse;
import com.example.demo.Secure.SignIn;


public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(userDTO userDTO);
    JWTAuthResponse refreshToken(String accessToken);
}
