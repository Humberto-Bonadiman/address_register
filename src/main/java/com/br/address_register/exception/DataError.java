package com.br.address_register.exception;

public class DataError {
    private String message;

    public DataError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
