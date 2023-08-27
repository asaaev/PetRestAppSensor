package com.asaev.restsensor.PetRestAppSensor.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {


    @NotNull(message = "Field value should not be empty")
    @DecimalMin(value = "-100", inclusive = true)
    @DecimalMax(value = "100", inclusive = true)
    private double measurementValue;

    @NotNull(message = "Field raining should not be empty")
    private boolean measurementRaining;

    private String sensor;



    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public boolean isMeasurementRaining() {
        return measurementRaining;
    }

    public void setMeasurementRaining(boolean measurementRaining) {
        this.measurementRaining = measurementRaining;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
