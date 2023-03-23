package com.kuba.carapi.service;

import com.kuba.carapi.exception.CarNotFoundException;
import com.kuba.carapi.model.Car;
import com.kuba.carapi.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("No such car in the database!"));
    }

    public List<Car> getCarsByColor(String color) {
        return carRepository.findCarsByColor(color);
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car){
        Car carToUpdate = getCarById(id);
//        carToUpdate.setId(car.getId());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setMark(car.getMark());
        carToUpdate.setModel(car.getModel());
        return carRepository.save(carToUpdate);
    }

    public Car updateCarColor(Long id, String color){
        Car car = getCarById(id);
        car.setColor(color);
        return carRepository.save(car);
    }

    public void deleteCar(Long id){
        Car car = getCarById(id);
        carRepository.deleteById(car.getId());
    }
}
