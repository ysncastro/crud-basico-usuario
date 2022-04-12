package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> handlerApiException(ApiException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .nomeDoErro("ApiException")
                .causa(exception.getMessage())
                .horaDoErro(LocalDateTime.now())
                .httpStatus(exception.getHttpStatus())
                .build();
        return new ResponseEntity<>(exceptionResponse, exception.getHttpStatus());
    }
}