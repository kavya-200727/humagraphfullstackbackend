package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.track.entity.HealthMetric;

@Repository
public interface HealthMetricRepository
        extends JpaRepository<HealthMetric, Long> {

}