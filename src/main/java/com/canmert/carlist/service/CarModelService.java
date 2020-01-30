package com.canmert.carlist.service;

import java.util.List;
import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.repository.CarModelRepository;
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
}