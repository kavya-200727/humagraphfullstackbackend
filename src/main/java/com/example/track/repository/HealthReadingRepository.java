package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.track.entity.HealthReading;

@Repository
public interface HealthReadingRepository
        extends JpaRepository<HealthReading, Long>{

}