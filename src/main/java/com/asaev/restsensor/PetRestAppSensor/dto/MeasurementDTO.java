package com.asaev.restsensor.PetRestAppSensor.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;

public class MeasurementDTO {


    @NotEmpty(message = "Field value should not be empty")
    @DecimalMin(value = "-100", inclusive = true)
    @DecimalMax(value = "100", inclusive = true)
    private double measurementValue;

    @NotEmpty(message = "Field raining should not be empty")
    private boolean measurementRaining;

    private SensorDTO sensor;



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

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
