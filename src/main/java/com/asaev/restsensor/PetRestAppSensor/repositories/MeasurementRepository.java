package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    @Query("SELECT COUNT(DISTINCT DATE(m.timestamp)) FROM Measurement m WHERE m.measurementRaining = true")
    long countRainyDays();

}
