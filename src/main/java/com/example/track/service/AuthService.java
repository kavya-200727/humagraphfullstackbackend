package com.example.track.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.track.entity.SystemUser;
import com.example.track.repository.SystemUserRepo;

@Service
public class AuthService {

    private final PasswordEncoder encoder;
    private final SystemUserRepo userRepo;

    public AuthService(PasswordEncoder encoder, SystemUserRepo userRepo) {
        this.encoder = encoder;
        this.userRepo = userRepo;
    }

    public SystemUser getUserByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public SystemUser register(SystemUser user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new org.springframework.dao.DataIntegrityViolationException("Email address is already registered.");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public boolean verifyPassword(String email, String password) {

        SystemUser user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // System.out.println("Entered Password : " + password);
        // System.out.println("Stored Password : " + user.getPassword());

        boolean result = encoder.matches(password, user.getPassword());

        System.out.println("Password Match : " + result);

        return result;
    }

}
