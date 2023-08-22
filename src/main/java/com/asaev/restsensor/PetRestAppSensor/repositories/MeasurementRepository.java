package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
