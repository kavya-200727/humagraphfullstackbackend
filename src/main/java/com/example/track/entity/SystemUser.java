package com.example.track.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users_table")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotBlank
    private String name;

    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private BiometricProfile biometricProfile;

    private Boolean isActive = true;

    public SystemUser() {
    }

    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    public SystemUser(Long id, @NotBlank String name, String email, @NotBlank String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = true;
    }

    public SystemUser(Long id, @NotBlank String name, String email, @NotBlank String password, Role role, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public BiometricProfile getBiometricProfile() {
        return biometricProfile;
    }

    public void setBiometricProfile(BiometricProfile biometricProfile) {
        this.biometricProfile = biometricProfile;
    }

    private java.time.LocalDateTime createdAt;

    @PrePersist
    public void createTime() {
        this.createdAt = java.time.LocalDateTime.now();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public enum Role {
        ADMIN,
        TRAINER,
        INDIVIDUAL,
        PRACTITIONER
    }

}