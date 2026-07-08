package com.example.track.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class HealthReading {

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

    @NotNull(message = "Numeric value is required")
    @Positive(message = "Value must be positive")
    private Double numericValue;
    @NotNull(message = "Recorded date is required")
    private LocalDateTime recordedAt;
    @NotBlank(message = "Source is required")
    private String source;
    @NotBlank(message = "Status is required")
    private String status;

    public HealthReading() {
    }

    public HealthReading(Long id, Long profileId, Long metricId, Double numericValue, LocalDateTime recordedAt, String source, String status) {
        this.id = id;
        this.profileId = profileId;
        this.metricId = metricId;
        this.numericValue = numericValue;
        this.recordedAt = recordedAt;
        this.source = source;
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

    public Double getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Double numericValue) {
        this.numericValue = numericValue;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}