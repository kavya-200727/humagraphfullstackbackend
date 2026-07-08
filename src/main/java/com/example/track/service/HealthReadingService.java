package com.example.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.track.entity.HealthReading;
import com.example.track.exception.HealthReadingNotFoundException;
import com.example.track.repository.HealthReadingRepository;

@Service
public class HealthReadingService {

    @Autowired
    HealthReadingRepository crep;
    public HealthReading saveData(HealthReading data){
        return crep.save(data);
    }
    public List<HealthReading> getAllData(){
        return crep.findAll();
    }
    public HealthReading getUserDetails(Long id){
        return crep.findById(id).orElseThrow(() ->
                new HealthReadingNotFoundException("Reading not found"));
    }
    public HealthReading updatedatabase(
            Long id,
            HealthReading data){
        HealthReading reading =crep.findById(id).orElseThrow(() ->
                new HealthReadingNotFoundException("Reading not found"));

        reading.setProfileId(data.getProfileId());
        reading.setMetricId(data.getMetricId());
        reading.setNumericValue(data.getNumericValue());
        reading.setRecordedAt(data.getRecordedAt());
        reading.setSource(data.getSource());
        reading.setStatus(data.getStatus());
        return crep.save(reading);
    }
    public HealthReading getDelete(Long id){
        HealthReading reading =crep.findById(id).orElseThrow(() ->
                new HealthReadingNotFoundException( "Reading not found"));

        crep.delete(reading);

        return reading;
    }
}