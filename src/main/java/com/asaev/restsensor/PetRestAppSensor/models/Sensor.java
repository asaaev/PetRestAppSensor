package com.asaev.restsensor.PetRestAppSensor.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private int sensorId;

    @NotEmpty(message = "The sensor name should not be empty")
    @Column(name = "sensor_name")
    @Size(min = 3, max = 30, message = "The sensor name must contain between 3 and 30 characters.")
    private String sensorName;

    public Sensor(){}
    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensor_id) {
        this.sensorId = sensor_id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensor_name) {
        this.sensorName = sensor_name;
    }
}
