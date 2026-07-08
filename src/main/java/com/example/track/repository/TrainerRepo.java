package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.track.entity.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer,Long>{
}
