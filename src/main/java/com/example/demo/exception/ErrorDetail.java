package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private String message;
    private LocalDate date;
    private String details;
}
