package com.example.welcomeservice.Exception.Handler;
import  com.example.welcomeservice.Exception.Handler.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WelcomeServiceExceptionController {

  @ExceptionHandler(value = UserNotFoundException.class)
  public ResponseEntity<Object> UserNotFoundExceptionHandler(UserNotFoundException exception) {
    return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(value = PropertyNotFoundException.class)
  public ResponseEntity<Object> PropertyNotFoundExceptionHandler(PropertyNotFoundException exception) {
    return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
  }



}
