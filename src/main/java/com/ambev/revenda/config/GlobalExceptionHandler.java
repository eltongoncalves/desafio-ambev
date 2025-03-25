package com.ambev.revenda.config;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsException> handleGenericException(Exception ex) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error: " + ex.getMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetailsException> handleBadRequestException(BadRequestException ex) {
        ErrorDetailsException errorDetails = new ErrorDetailsException(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request: " + ex.getMessage()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
