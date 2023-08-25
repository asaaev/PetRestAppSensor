package com.asaev.restsensor.PetRestAppSensor.repositories;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    //Query with filter per day
    @Query(value = "SELECT COUNT(DISTINCT DATE_TRUNC('day', m.timestamp)) FROM Measurement m WHERE m.raining = true", nativeQuery = true)
    long countRainyDays();

    @Query("SELECT COUNT(m) FROM Measurement m WHERE m.measurementRaining = true")
    Long getRainyMeasurementsCount();

}
