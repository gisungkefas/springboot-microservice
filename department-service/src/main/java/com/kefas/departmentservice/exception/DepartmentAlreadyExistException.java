package com.kefas.departmentservice.exception;

public class DepartmentAlreadyExistException extends RuntimeException{

    public DepartmentAlreadyExistException(String message) {
        super(message);
    }
}
