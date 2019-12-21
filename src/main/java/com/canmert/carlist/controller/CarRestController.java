package com.canmert.carlist.controller;

import java.util.List;

import javax.validation.Valid;

import com.canmert.carlist.model.Car;
import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.service.CarBrandService;
import com.canmert.carlist.service.CarModelService;
import com.canmert.carlist.service.CarService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CarRestController
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarRestController {

    private CarService carService;
    private CarBrandService carBrandService;
    private CarModelService carModelService;

    public CarRestController(CarService carService, CarBrandService carBrandService, CarModelService carModelService) {
        this.carService = carService;
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
    }

    @GetMapping(value = "/brands", produces = "application/json")
    public List<CarBrand> getAllBrands() {
        return carBrandService.getAll();
    }

    @PostMapping(value = "/brands")
    public CarBrand createBrand(@Valid @RequestBody CarBrand carBrand) {

        return carBrandService.create(carBrand);
    }

    @GetMapping(value = "/models/{brandId}", produces = "application/json")
    public List<CarModel> getModelsByBrandId(@PathVariable CarBrand brandId) {
        return carModelService.getByBrandId(brandId);
    }

    @GetMapping(value = "/models", produces = "application/json")
    public List<CarModel> getAllModels() {
        return carModelService.getAll();
    }

    @GetMapping(value = "/cars", produces = "application/json")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping(value = "/cars/{id}")
    public Car getOne(@PathVariable Long id) {
        return carService.getById(id);
    }

    @PostMapping(value = "/cars")
    public Car createCar(@Valid @RequestBody Car car) {

        return carService.create(car);
    }

    @PutMapping(value = "/cars/{id}")
    public Car updateCar(@PathVariable Long id, @Valid @RequestBody Car updatedCar) {
        return carService.update(updatedCar, id);
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        return carService.delete(id);
    }
}