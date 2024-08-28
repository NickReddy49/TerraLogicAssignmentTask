package com.terralogic.AssignmentTask.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Handle MultipleIllegalArgumentException
    @ExceptionHandler(MultipleIllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleMultipleIllegalArgumentException(MultipleIllegalArgumentException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("errors", ex.getErrors());
        errorResponse.put("message", "Validation failed");

        //Here returning a response entity with the list of errors and BAD_REQUEST status
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
