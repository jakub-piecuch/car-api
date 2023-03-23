package com.kuba.carapi.repository;

import com.kuba.carapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT cars FROM cars WHERE color = :color")
    List<Car> findCarsByColor(String color);
}
