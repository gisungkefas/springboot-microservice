package com.kefas.departmentservice.exception;

import com.kefas.departmentservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleStudentAlreadyExist(final DepartmentAlreadyExistException ex){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Student Already Exist, Please use a different email");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentAlreadyExist(final DepartmentNotFoundException ex){

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDebugMessage("Student not found, Please change your request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
