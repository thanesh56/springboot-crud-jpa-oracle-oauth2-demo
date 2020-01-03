package com.gl.springbootcrudjpaoracledemo.exception;

public class UserNotFoundException extends NotFoundException {
//    private Long userId;
//    public UserNotFoundException(Long userId) {
//        this.userId = userId;
//    }

    public UserNotFoundException(String exception) {
        super(exception);
    }
}
