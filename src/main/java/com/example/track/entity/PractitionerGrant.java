package com.example.track.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class PractitionerGrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "practitioner_id")
    @NotNull(message = "Practitioner ID is required")
    private Long practitionerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "practitioner_id", insertable = false, updatable = false)
    private SystemUser practitioner;

    @Column(name = "profile_id")
    @NotNull(message = "Profile ID is required")
    private Long profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private BiometricProfile profile;

    @Column(name = "granted_by_user_id")
    @NotNull(message = "Granted By User ID is required")
    private Long grantedByUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "granted_by_user_id", insertable = false, updatable = false)
    private SystemUser grantedByUser;

    @NotBlank(message = "Access level is required")
    private String accessLevel;
    @NotNull(message = "Grant date is required")
    private LocalDateTime grantedAt;
    @NotNull(message = "Expiry date is required")
    private LocalDateTime expiresAt;
    private boolean active;

    public PractitionerGrant() {
    }

    public PractitionerGrant(Long id, Long practitionerId,
            Long profileId, Long grantedByUserId,
            String accessLevel, LocalDateTime grantedAt,
            LocalDateTime expiresAt, boolean active) {

        this.id = id;
        this.practitionerId = practitionerId;
        this.profileId = profileId;
        this.grantedByUserId = grantedByUserId;
        this.accessLevel = accessLevel;
        this.grantedAt = grantedAt;
        this.expiresAt = expiresAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPractitionerId() {
        return practitionerId;
    }

    public void setPractitionerId(Long practitionerId) {
        this.practitionerId = practitionerId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getGrantedByUserId() {
        return grantedByUserId;
    }

    public void setGrantedByUserId(Long grantedByUserId) {
        this.grantedByUserId = grantedByUserId;
    }

    public SystemUser getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(SystemUser practitioner) {
        this.practitioner = practitioner;
    }

    public BiometricProfile getProfile() {
        return profile;
    }

    public void setProfile(BiometricProfile profile) {
        this.profile = profile;
    }

    public SystemUser getGrantedByUser() {
        return grantedByUser;
    }

    public void setGrantedByUser(SystemUser grantedByUser) {
        this.grantedByUser = grantedByUser;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public LocalDateTime getGrantedAt() {
        return grantedAt;
    }

    public void setGrantedAt(LocalDateTime grantedAt) {
        this.grantedAt = grantedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}