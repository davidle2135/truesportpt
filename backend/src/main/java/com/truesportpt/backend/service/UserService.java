package com.truesportpt.backend.service;

import com.truesportpt.backend.entity.*;
import com.truesportpt.backend.repository.*;
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
            throw new RuntimeException("Error: email already exists");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user == null) 
        {
            throw new RuntimeException("Error: user does not exist");
        }
        else
        {
            return user;
        }
    }
}
