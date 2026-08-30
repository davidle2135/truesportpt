package com.truesportpt.backend.service;

import com.truesportpt.backend.dto.*;
import com.truesportpt.backend.entity.*;
import com.truesportpt.backend.exception.UserNotFound;
import com.truesportpt.backend.repository.*;
// import com.truesportpt.backend.config.*;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;
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
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    // Constructor injection for Spring beans
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder
        , JWTService jwtService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
        user.setPassword(passwordEncoder.encode(request.getPassword()));
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
            throw new UserNotFound("Error: user doesn't exist");
        }
    }

    public AuthenticationResponse loginRequest(LoginRequest request)
    {
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new UserNotFound("User not found"));

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!matches)
        {
            throw new IllegalArgumentException("Invalid Credentials");
        }

        String token = jwtService.generateToken(user.getEmail());
        return new AuthenticationResponse(token);
    }
}
