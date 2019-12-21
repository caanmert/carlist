package com.canmert.carlist.repository;

import com.canmert.carlist.model.Car;
import com.canmert.carlist.model.CarBrand;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * CarRepository
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}