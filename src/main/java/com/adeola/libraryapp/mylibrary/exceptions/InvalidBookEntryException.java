package com.adeola.libraryapp.mylibrary.exceptions;

public class InvalidBookEntryException extends RuntimeException {

    public InvalidBookEntryException(String message){
        super(message);
    }
}
