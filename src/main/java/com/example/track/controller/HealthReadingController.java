package com.example.track.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.track.entity.HealthReading;
import com.example.track.service.HealthReadingService;
import jakarta.validation.Valid;

@RestController
public class HealthReadingController {
    @Autowired
    HealthReadingService crser;

    @PostMapping("/postReading")
    public HealthReading saveData(@Valid @RequestBody HealthReading data) {
        return crser.saveData(data);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/reading")
    public List<HealthReading> getData() {
        return crser.getAllData();
    }

    @GetMapping("/reading/{id}")
    public ResponseEntity<?> getUserData(
            @PathVariable Long id) {
        try {
            HealthReading getData = crser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reading not found");
        }
    }

    @PutMapping("/reading/{id}")
    public HealthReading updateData(
            @PathVariable Long id,
            @RequestBody HealthReading data) {

        return crser.updatedatabase(id, data);
    }

    @DeleteMapping("/reading/{id}")
    public ResponseEntity<?> getDeleteData(
            @PathVariable Long id) {
        try {
            HealthReading getData = crser.getDelete(id);

            return ResponseEntity.status(HttpStatus.OK).body(getData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reading not found");
        }
    }

}