package com.kefas.userservice.exception;

import com.kefas.userservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleStudentAlreadyExist(final StudentAlreadyExistException ex){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Student Already Exist, Please use a different email");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentAlreadyExist(final StudentNotFoundException ex){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Student not found, Please change your request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
