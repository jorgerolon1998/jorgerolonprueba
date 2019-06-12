package com.myjavablog.exception;

public class NotFoundException extends Exception {

    String message;
    public NotFoundException(String message) {
        this.message = message;
    }


}
