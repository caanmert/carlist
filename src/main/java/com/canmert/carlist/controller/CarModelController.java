package com.canmert.carlist.controller;

import java.util.List;

import javax.validation.Valid;

import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.service.CarModelService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarModelController {
    
    private CarModelService carModelService;

    public CarModelController(CarModelService carModelService){
        this.carModelService = carModelService;
    }

    @GetMapping(value = "/models", produces = "application/json")
    public List<CarModel> getAllModels() {
        return carModelService.getAll();
    }

    @GetMapping(value = "/models/{brandId}", produces = "application/json")
    public List<CarModel> getModelsByBrandId(@PathVariable Long brandId) {
        return carModelService.getByBrandId(brandId);
    }

    @PostMapping(value = "/models/{brandId}")
    public CarModel createModel(@Valid @RequestBody CarModel model,@PathVariable Long brandId){
        return carModelService.create(model,brandId);
    }
}