package com.example.demo.Service;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(SignUp signUp);
    JWTAuthResponse refreshToken(String accessToken);
}
