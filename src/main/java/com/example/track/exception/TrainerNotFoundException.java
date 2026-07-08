package com.example.track.exception;

public class TrainerNotFoundException extends RuntimeException {
    public TrainerNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
