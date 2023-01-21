package com.br.address_register.exception;

import com.br.address_register.exception.messages.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler({
            HttpClientErrorException.class,
            PersonNotFoundException.class
    })
    public ResponseEntity<Object> handlerNotFound(Exception exception) {
        return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
