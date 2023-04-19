package com.mvcspring.hotcat.exception;

import lombok.Data;

@Data
public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
