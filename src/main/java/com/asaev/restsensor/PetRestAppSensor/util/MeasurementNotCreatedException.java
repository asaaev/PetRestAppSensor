package com.asaev.restsensor.PetRestAppSensor.util;

import com.asaev.restsensor.PetRestAppSensor.models.Measurement;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String msg){
        super(msg);
    }
}
