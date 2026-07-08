package com.example.track.exception;

public class PractitionerGrantNotFoundException
        extends RuntimeException {

    public PractitionerGrantNotFoundException(
            String text) {

        super(text);
    }
}