package com.truesportpt.backend.dto;


//////////////////////////////////////////////////////////////////////////
// 
// When a user receives information about themselves from the application,
// only certain information is necessary, such as their ID, email, name,
// etc. We would not want to return sensitive information, such as the
// user password.
//
//////////////////////////////////////////////////////////////////////////
public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public UserResponse(Long id, String email, String firstName, String lastName)
    {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() 
    {
        return id;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getFirstName() 
    {
        return firstName;
    }


    public String getLastName() 
    {
        return lastName;
    }
}
