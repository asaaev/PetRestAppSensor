package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
