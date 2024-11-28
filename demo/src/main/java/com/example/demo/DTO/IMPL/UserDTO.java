package com.example.demo.DTO.IMPL;

import com.example.demo.DTO.SuperDto;
import com.example.demo.Entity.Role;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO implements SuperDto {
    @Id
    private String email;
    private String password;
    private Role role;
}
