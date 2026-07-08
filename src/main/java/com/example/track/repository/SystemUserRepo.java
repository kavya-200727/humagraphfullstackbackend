package com.example.track.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.track.entity.SystemUser;

public interface SystemUserRepo extends JpaRepository<SystemUser,Long> {
    Optional<SystemUser> findByEmail(String email);
} 