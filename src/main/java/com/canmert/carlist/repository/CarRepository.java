package com.canmert.carlist.repository;

import com.canmert.carlist.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CarRepository
 */
public interface CarRepository extends JpaRepository<Car, Long> {}