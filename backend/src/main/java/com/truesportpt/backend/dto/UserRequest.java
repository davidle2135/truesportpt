package com.truesportpt.backend.dto;

import jakarta.validation.constraints.*;

//////////////////////////////////////////////////////////////////////////
// 
// UserRequest only requires certain information to be provided when 
// a user tries to interact with the application, such as their first 
// name, last name, password. Any other database entries should not
// need to be provided by the user.
//
//////////////////////////////////////////////////////////////////////////
public class UserRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 10)
    private String password;

    @Email
    private String email;

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
