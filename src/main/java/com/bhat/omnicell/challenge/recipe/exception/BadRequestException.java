package com.bhat.omnicell.challenge.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends  RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message=message;
    }
}
