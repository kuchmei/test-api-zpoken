package com.example.testapizpoken.controller;

import com.example.testapizpoken.exception.DealNotFoundException;
import com.example.testapizpoken.exception.InvoiceNotFoundException;
import com.example.testapizpoken.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<Response> handleConflict(DealNotFoundException exception) {
        Response response = new Response(exception.getMessage(), exception.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<Response> handleConflict(InvoiceNotFoundException exception) {
        Response response = new Response(exception.getMessage(), exception.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}