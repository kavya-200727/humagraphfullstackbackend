package com.example.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.track.entity.HealthGoal;
import com.example.track.exception.HealthGoalNotFoundException;
import com.example.track.repository.HealthGoalRepository;

@Service
public class HealthGoalService {

    @Autowired
    HealthGoalRepository crep;
    public HealthGoal saveData(
            HealthGoal data){
        return crep.save(data);
    }
    public List<HealthGoal> getAllData(){
        return crep.findAll();
    }
    public HealthGoal getUserDetails(Long id){
        return crep.findById(id).orElseThrow(() ->
                new HealthGoalNotFoundException("Goal not found"));
    }
    public HealthGoal updatedatabase(
            Long id,
            HealthGoal data){
        HealthGoal goal =crep.findById(id).orElseThrow(() ->
                new HealthGoalNotFoundException("Goal not found"));

        goal.setProfileId(data.getProfileId());
        goal.setMetricId(data.getMetricId());
        goal.setTargetValue(data.getTargetValue());
        goal.setCurrentValue(data.getCurrentValue());
        goal.setTargetDate(data.getTargetDate());
        goal.setStatus(data.getStatus());
        return crep.save(goal);
    }
    public HealthGoal getDelete(Long id){
        HealthGoal goal =crep.findById(id).orElseThrow(() ->
                new HealthGoalNotFoundException("Goal not found"));

        crep.delete(goal);

        return goal;
    }
}