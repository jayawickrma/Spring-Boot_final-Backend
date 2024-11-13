package com.example.demo.Service.IMPL;

import com.example.demo.DAO.UserDao;
import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.Entity.IMPL.UserEntity;
import com.example.demo.Secure.JWTAuthResponse;
import com.example.demo.Secure.SignIn;
import com.example.demo.Service.AuthService;
import com.example.demo.Service.JWTService;
import com.example.demo.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDao userDao;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
         var user=userDao.findByEmail(signIn.getEmail())
                 .orElseThrow(() -> new RuntimeException("User not found"));
        var generatedToken=jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
        UserEntity saveUser=userDao.save(mapping.toUserEntity(userDTO));
        var generatedToken=jwtService.generateToken(saveUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
       var userName=jwtService.extractUserName(accessToken);
       var findUser=userDao.findByEmail(userName)
               .orElseThrow(() -> new RuntimeException("User not found"));
       var refreshToken=jwtService.refreshToken(findUser);
       return JWTAuthResponse.builder().token(refreshToken).build();
    }
}
