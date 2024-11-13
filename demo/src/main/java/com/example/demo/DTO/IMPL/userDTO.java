package com.example.demo.DTO.IMPL;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class userDTO {
    @Id
    private String email;
    private String password;
    private String role;
}
