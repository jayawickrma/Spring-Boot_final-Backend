package com.example.demo.Service;

import com.example.demo.DTO.IMPL.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId, UserDTO userDTO);
     List<UserDTO> getAllUsers();
     UserDetailsService userDetailsService();
}
