package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findBySensorName(String sensorName);
}
