package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
//    @Query("SELECT COUNT(DISTINCT DATE(m.timestamp)) FROM Measurement m WHERE m.measurementRaining = true")
@Query(value = "SELECT COUNT(DISTINCT DATE_TRUNC('day', m.timestamp)) FROM Measurement m WHERE m.raining = true", nativeQuery = true)

long countRainyDays();

}
