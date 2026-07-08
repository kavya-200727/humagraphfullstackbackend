package com.example.track.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAccountNotFoundException.class)
    public ResponseEntity<?> handleUserException(
            UserAccountNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(BiometricProfileNotFoundException.class)
    public ResponseEntity<?> handleProfileException(
            BiometricProfileNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(HealthMetricNotFoundException.class)
    public ResponseEntity<?> handleMetricException(
            HealthMetricNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(HealthReadingNotFoundException.class)
    public ResponseEntity<?> handleReadingException(
            HealthReadingNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(HealthGoalNotFoundException.class)
    public ResponseEntity<?> handleGoalException(
            HealthGoalNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(PractitionerGrantNotFoundException.class)
    public ResponseEntity<?> handleGrantException(
            PractitionerGrantNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationError(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder("Validation failed: ");
        e.getBindingResult().getFieldErrors().forEach(error ->
                sb.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(". "));
        
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("message", sb.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Map<String,String>> handleDataIntegrityException(org.springframework.dao.DataIntegrityViolationException e) {
        Map<String,String> errorResponse = new HashMap<>();
        String msg = e.getRootCause() != null ? e.getRootCause().getMessage() : e.getMessage();
        if (msg != null && (msg.toLowerCase().contains("email") || msg.toLowerCase().contains("users_table") || msg.toLowerCase().contains("duplicate entry"))) {
            errorResponse.put("message", "Email address is already registered.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        errorResponse.put("message", "Database integrity violation: " + msg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleAllExceptions(Exception e) {
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("message", e.getMessage() != null ? e.getMessage() : "An unexpected error occurred.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}