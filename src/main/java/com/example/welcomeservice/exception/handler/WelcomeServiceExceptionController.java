package com.example.welcomeservice.exception.handler;

import com.example.welcomeservice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WelcomeServiceExceptionController {

  @ExceptionHandler(value = UserNotFoundException.class)
  public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException exception) {
    return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(value = PropertyNotFoundException.class)
  public ResponseEntity<Object> propertyNotFoundExceptionHandler(PropertyNotFoundException exception) {
    return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = PropertySoldException.class)
  public ResponseEntity<Object> propertySoldExceptionHandler(PropertySoldException exception) {
    return new ResponseEntity<>("Property already sold", HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(value = JwtSignatureException.class)
  public ResponseEntity<Object> jwtSignatureException(JwtSignatureException exception) {
    return new ResponseEntity<>("Jwt token is not properly formatted", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = JwtTokenExpiredException.class)
  public ResponseEntity<Object> jwtTokenExpiredException(JwtTokenExpiredException exception) {
    return new ResponseEntity<>("Jwt Token has been expired", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = PropertyAlreadyRequested.class)
  public ResponseEntity<Object> propertyAlreadyRequested(PropertyAlreadyRequested exception) {
    return new ResponseEntity<>("Property Already requested to buy", HttpStatus.ALREADY_REPORTED);
  }

  @ExceptionHandler(value = PropertyNotRequested.class)
  public ResponseEntity<Object> propertyNotRequested(PropertyNotRequested exception) {
    return new ResponseEntity<>("Property was not requested to buy", HttpStatus.NOT_FOUND);
  }


}
