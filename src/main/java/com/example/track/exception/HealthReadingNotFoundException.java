package com.example.track.exception;

public class HealthReadingNotFoundException
        extends RuntimeException {

    public HealthReadingNotFoundException(
            String text) {

        super(text);
    }
}