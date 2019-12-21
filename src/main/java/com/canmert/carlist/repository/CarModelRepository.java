package com.canmert.carlist.repository;

import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CarModelRepository extends JpaRepository<CarModel, Long> {

   // CarModel findByBrandId(Long brandId);
   
    List<CarModel> findByBrandId(CarBrand brandId);
}