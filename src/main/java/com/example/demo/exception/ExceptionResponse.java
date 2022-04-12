package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    private String nomeDoErro;
    private Object causa;
    private LocalDateTime horaDoErro;
    private HttpStatus httpStatus;

}