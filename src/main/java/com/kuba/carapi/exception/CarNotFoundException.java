package com.kuba.carapi.exception;

import com.kuba.carapi.model.Car;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(String message){
        super(message);
    }
}
