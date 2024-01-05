package com.example.coursems.model;

public class ErrorMessage {
    private int statusCode;
    private String message;
    private String valueInput;

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorMessage(int statusCode, String message, String valueInput) {
        this.statusCode = statusCode;
        this.message = message;
        this.valueInput = valueInput;
    }

    public ErrorMessage() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValueInput() {
        return valueInput;
    }

    public void setValueInput(String valueInput) {
        this.valueInput = valueInput;
    }
}
