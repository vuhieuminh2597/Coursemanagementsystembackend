package com.example.coursems.exception;

public class InvalidPageParamException extends RuntimeException{
    private String valueInput;

    public InvalidPageParamException(String message, String valueInput1,String valueInput2) {
        super(message);
        this.valueInput = "value:'" + valueInput1 + "' " + "value:'" + valueInput2 + "'";
    }

    public String getValueInput() {
        return valueInput;
    }

    public void setValueInput(String valueInput) {
        this.valueInput = valueInput;
    }
}
