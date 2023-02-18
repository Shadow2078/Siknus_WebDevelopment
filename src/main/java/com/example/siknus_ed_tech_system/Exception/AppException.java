package com.example.siknus_ed_tech_system.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {
    private final HttpStatus status;

    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}



