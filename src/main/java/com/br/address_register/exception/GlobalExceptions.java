package com.br.address_register.exception;

import com.br.address_register.exception.messages.PersonNotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({
            NullPointerException.class,
            PropertyValueException.class,
            HttpMessageNotReadableException.class,
            DataIntegrityViolationException.class,
            InvalidDataAccessApiUsageException.class
    })
    public ResponseEntity<Object> handlerBadRequest(Exception exception) {
        return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({
            HttpClientErrorException.class,
            PersonNotFoundException.class
    })
    public ResponseEntity<Object> handlerNotFound(Exception exception) {
        return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
