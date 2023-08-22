package com.asaev.restsensor.PetRestAppSensor.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDTO {
    @NotEmpty(message = "The sensor name should not be empty")
    @Size(min = 3, max = 30, message = "The sensor name must contain between 3 and 30 characters.")
    private String sensorName;

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
