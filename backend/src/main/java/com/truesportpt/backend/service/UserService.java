package com.truesportpt.backend.service;

import com.truesportpt.backend.dto.UserRequest;
import com.truesportpt.backend.dto.UserResponse;
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

    public UserResponse createUser(UserRequest request)
    {
        if (userRepository.existsByEmail(request.getEmail())) 
        {
            throw new IllegalArgumentException("Error: email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return new UserResponse(user.getID(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

    public ResponseEntity<UserResponse> getUser(Long id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            User opt = user.get();
            UserResponse response = new UserResponse(id, opt.getEmail(), opt.getFirstName(), opt.getLastName());
            return ResponseEntity.ok(response);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
