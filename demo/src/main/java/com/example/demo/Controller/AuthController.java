package com.example.demo.Controller;

import com.example.demo.Service.AuthService;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vi/auth/")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
}
