package com.truesportpt.backend.dto;


//////////////////////////////////////////////////////////////////////////
// 
// UserRequest only requires certain information to be provided when 
// a user tries to interact with the application, such as their first 
// name, last name, password. Any other database entries should not
// need to be provided by the user.
//
//////////////////////////////////////////////////////////////////////////
public class UserRequest {

    private String firstName;
    private String lastName;
    private String password;
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
