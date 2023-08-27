package com.asaev.restsensor.PetRestAppSensor;

import com.asaev.restsensor.PetRestAppSensor.demo.SensorSimulator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetRestAppSensorApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetRestAppSensorApplication.class, args);


		final SensorSimulator sensorSimulator = new SensorSimulator();
//		sensorSimulator.sendMeasurements("first_sensor", 20);

	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
