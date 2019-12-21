package com.canmert.carlist.service;

import java.util.List;

import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.repository.CarBrandRepository;

import org.springframework.stereotype.Service;

/**
 * CarBrandService
 */
@Service
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    public List<CarBrand> getAll() {
        return carBrandRepository.findAll();
    }

    public CarBrand create(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }

}