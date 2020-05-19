package com.canmert.carlist.controller;

import java.util.List;

import javax.validation.Valid;

import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.service.CarBrandService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarBrandController {
    
    private CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService){
        this.carBrandService = carBrandService;
    }

    @GetMapping(value = "/brands", produces = "application/json")
    public List<CarBrand> getAllBrands() {
        return carBrandService.getAll();
    }

    @PostMapping(value = "/brands")
    public CarBrand createCarBrand(@Valid @RequestBody CarBrand carBrand) {

        return carBrandService.create(carBrand);
    }
}