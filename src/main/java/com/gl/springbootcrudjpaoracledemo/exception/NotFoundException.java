package com.gl.springbootcrudjpaoracledemo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}
