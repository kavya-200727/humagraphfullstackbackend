package com.example.track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.track.entity.PractitionerGrant;

@Repository
public interface PractitionerGrantRepository
        extends JpaRepository<PractitionerGrant, Long>{

}