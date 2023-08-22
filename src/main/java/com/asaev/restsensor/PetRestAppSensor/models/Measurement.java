package com.asaev.restsensor.PetRestAppSensor.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;

    @NotEmpty(message = "Field value should not be empty")
    @DecimalMin(value = "-100", inclusive = true)
    @DecimalMax(value = "100", inclusive = true)
    @Column(name = "value")
    private double measurementValue;


    @NotEmpty(message = "Field raining should not be empty")
    @Column(name = "raining")
    private boolean measurementRaining;

    @Column(name = "timestamp")
    private LocalDateTime measurementCreatedAtTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Measurement(){}

    public Measurement(double measurementValue, boolean measurementRaining, LocalDateTime measurementCreatedAtTime, Sensor sensor) {
        this.measurementValue = measurementValue;
        this.measurementRaining = measurementRaining;
        this.measurementCreatedAtTime = measurementCreatedAtTime;
        this.sensor = sensor;
    }

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }

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

    public LocalDateTime getMeasurementCreatedAtTime() {
        return measurementCreatedAtTime;
    }

    public void setMeasurementCreatedAtTime(LocalDateTime measurementCreatedAtTime) {
        this.measurementCreatedAtTime = measurementCreatedAtTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensorId) {
        this.sensor = sensorId;
    }
}
