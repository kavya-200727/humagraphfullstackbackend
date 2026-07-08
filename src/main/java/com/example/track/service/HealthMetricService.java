package com.example.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.track.entity.HealthMetric;
import com.example.track.exception.HealthMetricNotFoundException;
import com.example.track.repository.HealthMetricRepository;

@Service
public class HealthMetricService {

    @Autowired
    HealthMetricRepository crep;

    public HealthMetric saveData(HealthMetric data){
        return crep.save(data);
    }

    public List<HealthMetric> getAllData(){
        return crep.findAll();
    }

    public HealthMetric getUserDetails(Long id){

        return crep.findById(id)
                .orElseThrow(() ->
                new HealthMetricNotFoundException(
                        "Metric not found"));
    }

    public HealthMetric updatedatabase(
            Long id,
            HealthMetric data){

        HealthMetric metric =
                crep.findById(id)
                .orElseThrow(() ->
                new HealthMetricNotFoundException(
                        "Metric not found"));

        metric.setName(data.getName());
        metric.setUnit(data.getUnit());
        metric.setCategory(data.getCategory());
        metric.setSystemStandard(data.isSystemStandard());

        return crep.save(metric);
    }

    public HealthMetric getDelete(Long id){

        HealthMetric metric =
                crep.findById(id)
                .orElseThrow(() ->
                new HealthMetricNotFoundException(
                        "Metric not found"));

        crep.delete(metric);

        return metric;
    }
}