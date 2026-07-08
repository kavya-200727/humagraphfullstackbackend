package com.example.track.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.track.entity.SystemUser;
import com.example.track.exception.TrainerNotFoundException;
import com.example.track.repository.SystemUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    SystemUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      SystemUser user = userRepo.findByEmail(email).orElseThrow(() -> new TrainerNotFoundException("User not Found"));

      return User.builder()
             .username(user.getEmail())
             .password(user.getPassword())
             .roles(user.getRole().name())
             .disabled(user.getIsActive() != null && !user.getIsActive())
             .build();
    }
    
}
