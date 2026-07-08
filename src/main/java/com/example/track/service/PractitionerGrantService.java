package com.example.track.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.track.entity.PractitionerGrant;
import com.example.track.exception.PractitionerGrantNotFoundException;
import com.example.track.repository.PractitionerGrantRepository;

@Service
public class PractitionerGrantService {

    @Autowired
    PractitionerGrantRepository crep;

    public PractitionerGrant saveData(
            PractitionerGrant data){
        return crep.save(data);
    }
    public List<PractitionerGrant> getAllData(){
        return crep.findAll();
    }
    public PractitionerGrant getUserDetails(Long id){
        return crep.findById(id).orElseThrow(() ->
                new PractitionerGrantNotFoundException("Grant not found"));
    }
    public PractitionerGrant updatedatabase(Long id,PractitionerGrant data){
        PractitionerGrant grant =crep.findById(id).orElseThrow(() ->
                new PractitionerGrantNotFoundException("Grant not found"));
        grant.setPractitionerId(data.getPractitionerId());
        grant.setProfileId(data.getProfileId());
        grant.setGrantedByUserId(data.getGrantedByUserId());
        grant.setAccessLevel(data.getAccessLevel());
        grant.setGrantedAt(data.getGrantedAt());
        grant.setExpiresAt(data.getExpiresAt());
        grant.setActive(data.isActive());
        return crep.save(grant);
    }
    public PractitionerGrant getDelete(Long id){
        PractitionerGrant grant =crep.findById(id).orElseThrow(() ->
                new PractitionerGrantNotFoundException("Grant not found"));
        crep.delete(grant);
        return grant;
    }
}