package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.track.entity.HealthGoal;

@Repository
public interface HealthGoalRepository
        extends JpaRepository<HealthGoal, Long>{

}