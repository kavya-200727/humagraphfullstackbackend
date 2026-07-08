package com.example.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.track.entity.HealthGoal;
import com.example.track.service.HealthGoalService;

import jakarta.validation.Valid;
@RestController
public class HealthGoalController {
    @Autowired
    HealthGoalService crser;
    @PostMapping("/postGoal")
    public HealthGoal saveData(@Valid@RequestBody HealthGoal data){
        return crser.saveData(data);
    }
    @GetMapping("/goal")
    public List<HealthGoal> getData(){
        return crser.getAllData();
    }
    @GetMapping("/goal/{id}")
    public ResponseEntity<?> getUserData(
            @PathVariable Long id){
        try{
            HealthGoal getData =
                    crser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal not found");
        }
    }
    @PutMapping("/goal/{id}")
    public HealthGoal updateData(@PathVariable Long id,@RequestBody HealthGoal data){
        return crser.updatedatabase(id,data);
    }
    @DeleteMapping("/goal/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id){
        try{
            HealthGoal getData =crser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal not found");
        }
    }
   
}