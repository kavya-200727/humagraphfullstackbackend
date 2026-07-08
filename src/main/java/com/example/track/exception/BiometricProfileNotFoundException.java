package com.example.track.exception;

public class BiometricProfileNotFoundException
        extends RuntimeException {

    public BiometricProfileNotFoundException(
            String text) {

        super(text);
    }
}