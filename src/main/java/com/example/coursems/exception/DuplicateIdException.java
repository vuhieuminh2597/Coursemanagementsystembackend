package com.example.coursems.exception;

public class DuplicateIdException extends RuntimeException {
    private String valueInput;
    public DuplicateIdException(String message,String valueInput) {
        super(message);
        this.valueInput = valueInput;
    }

    public String getValueInput() {
        return valueInput;
    }

    public void setValueInput(String valueInput) {
        this.valueInput = valueInput;
    }
}
