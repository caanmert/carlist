
package com.canmert.carlist.service;

import java.util.List;
import java.util.Optional;

import com.canmert.carlist.exception.CarNotFoundException;
import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.repository.CarModelRepository;
import com.canmert.carlist.repository.CarRepository;

import org.springframework.stereotype.Service;

/**
 * CarModelService
 */
@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    public List<CarModel> getByBrandId(CarBrand brandId) {
        return carModelRepository.findByBrandId(brandId);
    }

    public CarModel getById(Long id) {
        return carModelRepository.findById(id).orElseThrow(CarNotFoundException::new);
    }

    public List<CarModel> getAll() {
        return carModelRepository.findAll();
    }
}