package com.example.demo.Service;

import com.example.demo.DTO.IMPL.UserDTO;
import com.example.demo.DTO.IMPL.UserWithKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    UserDetailsService userDetailsService();
    boolean sendCodeToChangePassword(UserWithKey userWithKey);
}
