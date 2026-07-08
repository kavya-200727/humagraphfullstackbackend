package com.example.track.service;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.track.entity.UserAccount;
import com.example.track.exception.UserAccountNotFoundException;
import com.example.track.repository.UserAccountRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class UserAccountService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.exp}")
    private long exp;

    @Autowired
    private UserAccountRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserAccount saveData(UserAccount data){

        String bcryptPassword =
                passwordEncoder.encode(
                        data.getPasswordHash());

        data.setPasswordHash(bcryptPassword);

        return repo.save(data);
    }

    public List<UserAccount> getAllData(){
        return repo.findAll();
    }

    public UserAccount getUserDetails(Long id){

        return repo.findById(id)
                .orElseThrow(() ->
                        new UserAccountNotFoundException(
                                "User not found"));
    }

    public UserAccount updatedatabase(
            Long id,
            UserAccount data){

        UserAccount user =
                repo.findById(id)
                        .orElseThrow(() ->
                                new UserAccountNotFoundException(
                                        "User not found"));

        user.setEmail(data.getEmail());

        String bcryptPassword =
                passwordEncoder.encode(
                        data.getPasswordHash());

        user.setPasswordHash(bcryptPassword);

        user.setRole(data.getRole());

        user.setIsActive(data.getIsActive());

        return repo.save(user);
    }

    public UserAccount getDelete(Long id){

        UserAccount user =
                repo.findById(id)
                        .orElseThrow(() ->
                                new UserAccountNotFoundException(
                                        "User not found"));

        repo.delete(user);

        return user;
    }

    public String generateToken(String email){

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + exp))
                .signWith(getKeys())
                .compact();
    }

    private Key getKeys(){

        return Keys.hmacShaKeyFor(
                secret.getBytes());
    }
}