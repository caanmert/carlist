package com.canmert.carlist.repository;

import com.canmert.carlist.model.CarBrand;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * CarRepository
 */
public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {

}