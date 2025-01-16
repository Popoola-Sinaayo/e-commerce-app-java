package com.personal.commerce.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.personal.commerce.dto.ResponseDto;
import com.personal.commerce.utils.ResourceNotFoundException;

@ControllerAdvice
public class ErrorHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        ResponseDto<String> error = new ResponseDto<String>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<String>> handleGenericException(Exception ex) {
        ResponseDto<String> error = new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred", "An unexpected error occurred");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
