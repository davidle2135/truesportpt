package com.truesportpt.backend.controller;

import com.truesportpt.backend.entity.*;
import com.truesportpt.backend.service.*;

import java.util.Optional;

// import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//////////////////////////////////////////////////////////////////////////
// 
// UserController controls HTTP requests and responses on the user side.
//
//////////////////////////////////////////////////////////////////////////
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) 
    {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) 
    {
        return userService.getUser(id);
    }
    
    

}
