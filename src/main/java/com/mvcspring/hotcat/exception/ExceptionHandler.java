package com.mvcspring.hotcat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<StandardResponse> handleClassNotFoundException(ClassNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        e.getMessage(),
                        e
                ), HttpStatus.NOT_FOUND
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardException> handleUserNotFoundException(NotFoundException e){
        return new ResponseEntity<>(
                new StandardException(
                        404,
                        e.getMessage()
                ),HttpStatus.NOT_FOUND
                );
    }
}
