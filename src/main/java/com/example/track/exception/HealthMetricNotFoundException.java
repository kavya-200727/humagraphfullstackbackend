package com.example.track.exception;

public class HealthMetricNotFoundException extends RuntimeException {

    public HealthMetricNotFoundException(String text) {

        super(text);
    }
}