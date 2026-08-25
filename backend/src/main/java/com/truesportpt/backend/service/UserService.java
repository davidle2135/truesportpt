package com.truesportpt.backend.service;

import com.truesportpt.backend.entity.*;
import com.truesportpt.backend.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import java.util.List;
import java.util.Optional;


//////////////////////////////////////////////////////////////////////////
// 
// The service layer provides business logic when communicating with the 
// frontend, such as creating, and finding users.
//
//////////////////////////////////////////////////////////////////////////
@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User createUser(User user)
    {
        if (userRepository.existsByEmail(user.getEmail())) 
        {
            throw new IllegalArgumentException("Error: email already exists");
        }
        return userRepository.save(user);
    }

    public ResponseEntity<User> getUser(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            return ResponseEntity.ok(user.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
