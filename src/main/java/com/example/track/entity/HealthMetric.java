package com.example.track.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class HealthMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Metric name is required")
    @Size(min = 3, max = 30,message = "Metric name must contain 3-30 characters")
    private String name;
    @NotBlank(message = "Unit is required")
    private String unit;
    @NotBlank(message = "Category is required")
    private String category;
    private boolean systemStandard;
    public HealthMetric() {
    }
    public HealthMetric(Long id, String name, String unit,String category, boolean systemStandard) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.systemStandard = systemStandard;
    }

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSystemStandard() {
        return systemStandard;
    }

    public void setSystemStandard(boolean systemStandard) {
        this.systemStandard = systemStandard;
    }
}