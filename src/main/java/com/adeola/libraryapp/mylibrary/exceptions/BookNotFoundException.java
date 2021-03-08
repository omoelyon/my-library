package com.adeola.libraryapp.mylibrary.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.RESET_CONTENT)
//@ControllerAdvice
//@Slf4j
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
//        return error(HttpStatus.RESET_CONTENT, e);
//    }
//
//    private ResponseEntity<String> error(HttpStatus status, Exception e) {
//        log.error("Exception : ", e);
//        return ResponseEntity.status(status).body(e.getMessage());
//    }
}
