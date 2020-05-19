package com.canmert.carlist.service;

import java.util.List;
import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.repository.CarModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CarModelService
 */
@Service
public class CarModelService {
    @Autowired
    private final CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    public List<CarModel> getByBrandId(Long brandId) {
        return carModelRepository.findByBrandId(brandId);
    }

    public List<CarModel> getAll(){
        return carModelRepository.findAll();
    }

    public CarModel create(CarModel model,Long brandId){
        return carModelRepository.save(model);
    }

    /*public CarModel create(CarModel model,Long brandId){
        List <CarModel> carModel = carModelRepository.findByBrandId(brandId);

        return carModelRepository.save(model);
        
    }*/
}