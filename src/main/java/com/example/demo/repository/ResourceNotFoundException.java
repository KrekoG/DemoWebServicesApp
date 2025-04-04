package com.example.demo.repository;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundException extends RuntimeException {

    private HttpStatus status = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(String message) {
        this(message, HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
