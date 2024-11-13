package com.example.demo.Service;

import com.example.demo.DTO.IMPL.userDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(userDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, userDTO userDTO);
     List<userDTO> getAllUsers();
     UserDetailsService userDetailsService();
}
