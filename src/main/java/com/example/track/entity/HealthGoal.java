package com.example.track.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class HealthGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_id")
    @NotNull(message = "Profile ID is required")
    private Long profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private BiometricProfile profile;

    @Column(name = "metric_id")
    @NotNull(message = "Metric ID is required")
    private Long metricId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id", insertable = false, updatable = false)
    private HealthMetric metric;

    @NotNull(message = "Target value is required")
    private Double targetValue;
    @NotNull(message = "Current value is required")
    private Double currentValue;
    private LocalDate targetDate;
    @NotBlank(message = "Status is required")
    private String status;

    public HealthGoal() {
    }

    public HealthGoal(Long id, Long profileId,
            Long metricId, Double targetValue,
            Double currentValue,
            LocalDate targetDate,
            String status) {

        this.id = id;
        this.profileId = profileId;
        this.metricId = metricId;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getMetricId() {
        return metricId;
    }

    public void setMetricId(Long metricId) {
        this.metricId = metricId;
    }

    public BiometricProfile getProfile() {
        return profile;
    }

    public void setProfile(BiometricProfile profile) {
        this.profile = profile;
    }

    public HealthMetric getMetric() {
        return metric;
    }

    public void setMetric(HealthMetric metric) {
        this.metric = metric;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}