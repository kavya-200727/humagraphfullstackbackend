package com.example.track.exception;

public class HealthGoalNotFoundException
        extends RuntimeException {

    public HealthGoalNotFoundException(
            String text) {

        super(text);
    }
}