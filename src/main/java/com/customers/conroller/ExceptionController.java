package com.customers.conroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<String> genericHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Sorry! Something went wrong.");
    }

}
