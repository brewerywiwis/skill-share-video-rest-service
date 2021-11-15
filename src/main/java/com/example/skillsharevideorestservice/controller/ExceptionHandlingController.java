package com.example.skillsharevideorestservice.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingController {
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Data invalid")
    @ExceptionHandler(RuntimeException.class)
    public String conflict(Exception e) {
        return e.getMessage();
    }
}
