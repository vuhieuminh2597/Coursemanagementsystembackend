package com.example.coursems.exception;

public class InvalidIdException extends RuntimeException{
    private String inputValue;
    public InvalidIdException(String message,String inputValue) {
        super(message);
        this.inputValue = inputValue;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
