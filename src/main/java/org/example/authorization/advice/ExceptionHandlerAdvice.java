package org.example.authorization.advice;

import org.example.authorization.exceptions.InvalidCredentials;
import org.example.authorization.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invHandler(RuntimeException e){
        return new ResponseEntity<>("RuntimeException in throwException method "+e, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unaHandler(RuntimeException e){
        return new ResponseEntity<>("RuntimeException in throwException method "+e, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> bindHandler(BindException e){
        return new ResponseEntity<>("BindException in throwException method "+e, HttpStatus.I_AM_A_TEAPOT);
    }
}