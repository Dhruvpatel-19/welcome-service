package com.example.welcomeservice.exception.handler;

import com.example.welcomeservice.exception.PropertyNotFoundException;
import com.example.welcomeservice.exception.UserNotFoundException;
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
