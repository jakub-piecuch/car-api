package com.kuba.carapi.controller;

import com.kuba.carapi.model.Car;
import com.kuba.carapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @GetMapping("/{color}")
    public ResponseEntity<List<Car>> getCarByColor(@PathVariable("color") String color){
        List<Car> carsByColor = carService.getCarsByColor(color);
        return new ResponseEntity<>(carsByColor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car addedCar = carService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id,
                                         @RequestBody Car car){
        Car updatedCar = carService.updateCar(id, car);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updateCarColor(@PathVariable("id") Long id,
                                              @RequestParam String color){
        Car updatedCar = carService.updateCarColor(id, color);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
