package com.example.demo.Security.Secure;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignIn {
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
}
