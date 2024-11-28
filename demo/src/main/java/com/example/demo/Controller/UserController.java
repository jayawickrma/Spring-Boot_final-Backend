package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.Exception.DataPersistException;
import com.example.demo.Security.Responce.JWTAuthResponse;
import com.example.demo.Security.Secure.SignUp;
import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/auth")
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JWTAuthResponse> saveUser(@RequestBody SignUp signUp){
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }
}
