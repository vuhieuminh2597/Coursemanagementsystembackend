package com.example.coursems.exception.global;

import com.example.coursems.exception.*;
import com.example.coursems.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNullObject(NotFoundException e, WebRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getValueInput());
    }

    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidId(InvalidIdException e, WebRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getInputValue());
    }

    @ExceptionHandler(InvalidParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidParam(Exception e, WebRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(DuplicateIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleDuplicateId(DuplicateIdException e, WebRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getValueInput());
    }
    @ExceptionHandler(DuplicateNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleDuplicateId(DuplicateNameException e, WebRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getValueInput());
    }

    @ExceptionHandler(InvalidPageParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleDuplicateId(InvalidPageParamException e, WebRequest request) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getValueInput());
    }
}
