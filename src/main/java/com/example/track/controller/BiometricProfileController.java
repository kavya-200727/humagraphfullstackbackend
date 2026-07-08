package com.example.track.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.track.entity.BiometricProfile;
import com.example.track.entity.SystemUser;
import com.example.track.service.BiometricProfileService;
import com.example.track.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class BiometricProfileController {

    @Autowired
    private BiometricProfileService crser;

    @Autowired
    private AuthService authService;

    @PostMapping("/postProfile")
    public BiometricProfile saveData(@Valid @RequestBody BiometricProfile data) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            SystemUser user = authService.getUserByEmail(email);
            if (user != null) {
                data.setUserId(user.getId());
            }
        }
        return crser.saveData(data);
    }

    @GetMapping("/profile")
    public List<BiometricProfile> getData() {
        return crser.getAllData();
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Long id) {
        try {
            BiometricProfile profileData = crser.getUserDetails(id);
            return ResponseEntity.ok(profileData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile not found");
        }
    }

    @PutMapping("/profile/{id}")
    public BiometricProfile updateData(@PathVariable Long id, @RequestBody BiometricProfile data) {
        return crser.updatedatabase(id, data);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Long id) {
        try {
            BiometricProfile profileData = crser.getDelete(id);
            return ResponseEntity.status(HttpStatus.OK).body(profileData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile not found");
        }
    }
}
