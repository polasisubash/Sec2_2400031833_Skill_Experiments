package com.klu.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e) {
    //initialize map object first
    Map<String, Object> error = new HashMap<>();
    error.put("timestamp", LocalDateTime.now());
    error.put("status", HttpStatus.NOT_FOUND.value());
    error.put("message", e.getMessage());
    
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleInternalServerErrorException(Exception e) {
    //initialize map object first
    Map<String, Object> error = new HashMap<>();
    error.put("timestamp", LocalDateTime.now());
    error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    error.put("message", e.getMessage());
    
    return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
  }
}