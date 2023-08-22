package com.asaev.restsensor.PetRestAppSensor.services;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import com.asaev.restsensor.PetRestAppSensor.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Transactional(readOnly = false)
    public void addMeasurement(Measurement measurement){
        measurementRepository.save(measurement);
    }

    public List<Measurement> findAll (){
        return measurementRepository.findAll();
    }

    public Long getRainyDaysCount(){
        return measurementRepository.countRainyDays();
    }

}
