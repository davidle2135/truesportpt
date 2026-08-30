package com.truesportpt.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 10)
    private String password;

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
