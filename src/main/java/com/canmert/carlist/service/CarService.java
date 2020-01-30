package com.canmert.carlist.service;

import java.util.List;

import com.canmert.carlist.exception.CarNotFoundException;
import com.canmert.carlist.model.Car;
import com.canmert.carlist.repository.CarRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * CarService
 */
@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow(CarNotFoundException::new);
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car updatedCar, Long id) {
        Car car = carRepository.findById(id).orElseThrow(CarNotFoundException::new);
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setTransmission(updatedCar.getTransmission());
        return carRepository.save(car);
    }

    public ResponseEntity<Car> delete(Long id) {
        Car car = carRepository.findById(id).orElseThrow(CarNotFoundException::new);
        carRepository.delete(car);
        return ResponseEntity.ok(car);
    }

}