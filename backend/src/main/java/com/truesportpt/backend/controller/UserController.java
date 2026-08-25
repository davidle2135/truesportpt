package com.truesportpt.backend.controller;

import com.truesportpt.backend.service.*;
import com.truesportpt.backend.dto.*;

import org.springframework.http.*;
// import java.util.List;
import org.springframework.web.bind.annotation.*;



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
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) 
    {
        try 
        {
            UserResponse u = userService.createUser(request);
            return ResponseEntity.ok(u);
        } 
        catch (IllegalArgumentException e)
        {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) 
    {
        return userService.getUser(id);
    }
    
    

}
