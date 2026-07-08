package com.example.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.track.entity.BiometricProfile;
import com.example.track.exception.BiometricProfileNotFoundException;
import com.example.track.repository.BiometricProfileRepository;

@Service
public class BiometricProfileService {

    @Autowired
    BiometricProfileRepository crep;
    public BiometricProfile saveData(BiometricProfile data){
        return crep.save(data);
    }
    public List<BiometricProfile> getAllData(){
        return crep.findAll();
    }
    public BiometricProfile getUserDetails(Long id){
        return crep.findById(id).orElseThrow(() ->
            new BiometricProfileNotFoundException("Profile not found"));
    }
    public BiometricProfile updatedatabase(
            Long id,
            BiometricProfile data){
        BiometricProfile profile =crep.findById(id).orElseThrow(() ->
                new BiometricProfileNotFoundException("Profile not found"));

        profile.setFullName(data.getFullName());
        profile.setDateOfBirth(data.getDateOfBirth());
        profile.setGender(data.getGender());
        profile.setBloodType(data.getBloodType());
        profile.setPhoneNumber(data.getPhoneNumber());
        profile.setAddress(data.getAddress());
        profile.setEmergencyContact(data.getEmergencyContact());
        profile.setMedicalHistory(data.getMedicalHistory());

        return crep.save(profile);
    }

    public BiometricProfile getDelete(Long id){
        BiometricProfile profile =crep.findById(id).orElseThrow(() ->
                new BiometricProfileNotFoundException("Profile not found"));

        crep.delete(profile);

        return profile;
    }
}