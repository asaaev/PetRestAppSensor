package com.asaev.restsensor.PetRestAppSensor.demo;

import com.asaev.restsensor.PetRestAppSensor.dto.MeasurementDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SensorSimulator {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080";

    public void sendMeasurements(String sensorName, int count) {
        for (int i = 0; i < count; i++) {

            MeasurementDTO measurementDTO = new MeasurementDTO();
            measurementDTO.setMeasurementValue(ThreadLocalRandom.current().nextDouble(-40, 40));
            measurementDTO.setMeasurementRaining(ThreadLocalRandom.current().nextBoolean());
            measurementDTO.setSensor(sensorName);

            restTemplate.postForEntity(BASE_URL + "/measurements/add", measurementDTO, Void.class);
        }
    }

    public List<MeasurementDTO> getMeasurements() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL + "/measurements", MeasurementDTO[].class));


    }
}
