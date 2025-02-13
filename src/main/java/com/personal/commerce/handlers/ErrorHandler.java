package com.personal.commerce.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.personal.commerce.dto.ResponseDto;
import com.personal.commerce.utils.ResourceBadRequestException;
import com.personal.commerce.utils.ResourceNotFoundException;

@ControllerAdvice
public class ErrorHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<ResponseDto<String>> handleResourceNotFound(ResourceNotFoundException ex) {
         ResponseDto<String> error = new ResponseDto<String>(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                 null);
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
     }
    
      @ExceptionHandler(ResourceBadRequestException.class)
      public ResponseEntity<ResponseDto<String>> handleResourceBadRequest(ResourceBadRequestException ex) {
          ResponseDto<String> error = new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
          return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
      }
    
      @ExceptionHandler(NoHandlerFoundException.class)
      public ResponseEntity<ResponseDto<String>> handleNotFound(NoHandlerFoundException ex) {
         ResponseDto<String> error = new ResponseDto<String>(HttpStatus.NOT_FOUND.value(), "Route Not Found", null);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<String>> handleGenericException(Exception ex) {
        System.out.println(ex);
        ResponseDto<String> error = new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred", null);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
