package com.asaev.restsensor.PetRestAppSensor.services;

import com.asaev.restsensor.PetRestAppSensor.models.Sensor;
import com.asaev.restsensor.PetRestAppSensor.repositories.SensorRepository;
import com.asaev.restsensor.PetRestAppSensor.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }
    public Sensor findOne(int id){
        Optional<Sensor> findSensor = sensorRepository.findById(id);
        return findSensor.orElseThrow(SensorNotFoundException::new);
    }
}
