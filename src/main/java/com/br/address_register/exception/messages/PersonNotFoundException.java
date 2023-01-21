package com.br.address_register.exception.messages;

public class PersonNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PersonNotFoundException() {
        super("Person not found!");
    }
}