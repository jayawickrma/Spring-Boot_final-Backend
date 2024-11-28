package com.example.demo.DTO.IMPL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserWithKey {
    private String email;
    private String code;
}
