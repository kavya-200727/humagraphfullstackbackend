package com.example.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.track.entity.HealthMetric;
import com.example.track.service.HealthMetricService;

import jakarta.validation.Valid;

@RestController
public class HealthMetricController {
    @Autowired
    HealthMetricService crser;
    @PostMapping("/postMetric")
    public HealthMetric saveData(@Valid@RequestBody HealthMetric data){
        return crser.saveData(data);
    }
    @GetMapping("/metric")
    public List<HealthMetric> getData(){
        return crser.getAllData();
    }
    @GetMapping("/metric/{id}")
    public ResponseEntity<?> getUserData(
            @PathVariable Long id){
        try{
            HealthMetric getData =crser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metric not found");
        }
    }
    @PutMapping("/metric/{id}")
    public HealthMetric updateData(
            @PathVariable Long id,
            @RequestBody HealthMetric data){
        return crser.updatedatabase(id,data);
    }
    @DeleteMapping("/metric/{id}")
    public ResponseEntity<?> getDeleteData(
            @PathVariable Long id){
        try{
            HealthMetric getData =crser.getDelete(id);

            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Metric not found");
        }
    }
    
}