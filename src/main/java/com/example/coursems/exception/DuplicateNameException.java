package com.example.coursems.exception;

public class DuplicateNameException extends RuntimeException {
    private String valueInput;

    public DuplicateNameException(String message, String valueInput) {
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
