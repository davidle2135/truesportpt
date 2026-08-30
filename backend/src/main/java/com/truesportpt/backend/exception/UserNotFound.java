package com.truesportpt.backend.exception;

public class UserNotFound extends RuntimeException {
    
    public UserNotFound(String message)
    {
        super(message);
    }
}
