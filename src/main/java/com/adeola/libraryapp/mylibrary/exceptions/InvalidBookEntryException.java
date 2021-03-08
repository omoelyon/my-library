package com.adeola.libraryapp.mylibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.RESET_CONTENT)
public class InvalidBookEntryException extends RuntimeException {

    public InvalidBookEntryException(String message){
        super(message);
    }
}
