package com.example.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.track.entity.PractitionerGrant;
import com.example.track.service.PractitionerGrantService;
import jakarta.validation.Valid;
@RestController
public class PractitionerGrantController {
    @Autowired
    PractitionerGrantService crser;
    @PostMapping("/postGrant")
    public PractitionerGrant saveData(@Valid@RequestBody PractitionerGrant data){
        return crser.saveData(data);
    }
    @GetMapping("/grant")
    public List<PractitionerGrant> getData(){
        return crser.getAllData();
    }
    @GetMapping("/grant/{id}")
    public ResponseEntity<?> getUserData(
            @PathVariable Long id){
        try{
            PractitionerGrant getData =crser.getUserDetails(id);
            return ResponseEntity.ok(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grant not found");
        }
    }
    @PutMapping("/grant/{id}")
    public PractitionerGrant updateData(@PathVariable Long id,@RequestBody PractitionerGrant data){
        return crser.updatedatabase(id,data);
    }
    @DeleteMapping("/grant/{id}")
    public ResponseEntity<?> getDeleteData(
            @PathVariable Long id){
        try{
            PractitionerGrant getData =crser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(getData);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grant not found");
        }
    }
    
}
