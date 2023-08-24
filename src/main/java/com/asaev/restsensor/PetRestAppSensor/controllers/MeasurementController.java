package com.asaev.restsensor.PetRestAppSensor.controllers;

import com.asaev.restsensor.PetRestAppSensor.dto.MeasurementDTO;
import com.asaev.restsensor.PetRestAppSensor.models.Measurement;
import com.asaev.restsensor.PetRestAppSensor.services.MeasurementService;
import com.asaev.restsensor.PetRestAppSensor.services.SensorService;
import com.asaev.restsensor.PetRestAppSensor.util.*;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService, SensorService sensorService, ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MeasurementDTO> getAllMeasurements(){
        return measurementService.findAllMeasurements().stream().map(this::convertToMeasurementDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> rainyDaysCount(){
        Long count = measurementService.getRainyDaysCount();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus>createMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                       BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors) {
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new MeasurementNotCreatedException(errorMsg.toString());
        }
        measurementService.saveNewMeasurement(convertToMeasurement(measurementDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }
    private MeasurementDTO convertToMeasurementDTO(Measurement measurement){
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse>handleException(MeasurementNotCreatedException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    private ResponseEntity<ErrorResponse>handleException(MeasurementNotFoundException e){
        ErrorResponse response = new ErrorResponse("Measurements with this id was not found"
                , System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
