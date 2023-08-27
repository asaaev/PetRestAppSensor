package com.asaev.restsensor.PetRestAppSensor.services;

import com.asaev.restsensor.PetRestAppSensor.models.Sensor;
import com.asaev.restsensor.PetRestAppSensor.repositories.SensorRepository;
import com.asaev.restsensor.PetRestAppSensor.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }
    public Sensor findSensorById(int id){
        Optional<Sensor> findSensor = sensorRepository.findById(id);
        return findSensor.orElseThrow(SensorNotFoundException::new);
    }
    public Sensor findSensorByName(String sensorName){
        Optional<Sensor> findByName = sensorRepository.findBySensorName(sensorName);
        return findByName.orElseThrow(SensorNotFoundException::new);
    }
    @Transactional(readOnly = false)
    public void saveNewSensor(Sensor sensor){
        sensorRepository.save(sensor);
    }

}
