package com.example.track.exception;

public class UserAccountNotFoundException
        extends RuntimeException {

    public UserAccountNotFoundException(
            String text) {

        super(text);
    }
}