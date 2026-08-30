package com.truesportpt.backend.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;


//////////////////////////////////////////////////////////////////////////
// 
// GlobalExceptionHandler will catch all exceptions regardless of where 
// the error occurs, and will route to these methods depending on the 
// error thrown.
//
//////////////////////////////////////////////////////////////////////////
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e)
    {
        return ResponseEntity.status(409).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFound e)
    {
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
