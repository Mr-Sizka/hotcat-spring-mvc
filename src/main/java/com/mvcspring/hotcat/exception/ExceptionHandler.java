package com.mvcspring.hotcat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<StandardResponse> handleClassNotFoundException(ClassNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        e.getMessage(),
                        e
                ), HttpStatus.NOT_FOUND
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<StandardResponse> handleNullPointException(NullPointerException e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        "User Not Found!",
                        e
                ),HttpStatus.NOT_FOUND
        );
    }
}
