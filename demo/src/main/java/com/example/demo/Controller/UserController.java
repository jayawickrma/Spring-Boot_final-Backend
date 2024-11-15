package com.example.demo.Controller;

import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveUser(@RequestPart("email")String email,
                                        @RequestPart("password")String password,
                                        @RequestPart("role")String role){

        UserDTO userDTO =new UserDTO();
            userDTO.setEmail(email);
            userDTO.setPassword(password);
            userDTO.setRole(role);

            userService.saveUser(userDTO);
            return ResponseEntity.ok().build();
    }
}
