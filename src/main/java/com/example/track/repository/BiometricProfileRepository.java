package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.track.entity.BiometricProfile;

@Repository
public interface BiometricProfileRepository
        extends JpaRepository<BiometricProfile, Long>{

}