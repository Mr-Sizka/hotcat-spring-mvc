package com.mvcspring.hotcat.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardException {
    private int code;
    String message;
}
