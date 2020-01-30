package com.canmert.carlist;

import com.canmert.carlist.model.Car;
import com.canmert.carlist.model.CarBrand;
import com.canmert.carlist.model.CarModel;
import com.canmert.carlist.model.User;
import com.canmert.carlist.repository.CarBrandRepository;
import com.canmert.carlist.repository.CarModelRepository;
import com.canmert.carlist.repository.CarRepository;
import com.canmert.carlist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarlistApplication {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarBrandRepository carBrandRepository;

	@Autowired
	private CarModelRepository carModelRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarlistApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			carRepository.save(new Car("Bmw", "3 series", 2006));
			carRepository.save(new Car("Bmw", "5 series", 2003));
			carRepository.save(new Car("Audi", "a4", 2009));
			carRepository.save(new Car("Toyota", "Corolla", 2002));
			carRepository.save(new Car("Ford", "Fiesta", 2012));
			carRepository.save(new Car("Ford", "Mustang", 2012));

			carBrandRepository.save(new CarBrand(1L, "Audi"));
			carBrandRepository.save(new CarBrand(2L, "BMW"));
			carBrandRepository.save(new CarBrand(3L, "Ford"));
			carBrandRepository.save(new CarBrand(4L, "Mercedes-Benz"));

			carModelRepository.save(new CarModel(new CarBrand(7L), "A3"));
			carModelRepository.save(new CarModel(new CarBrand(7L), "A4"));
			carModelRepository.save(new CarModel(new CarBrand(7L), "A5"));
			carModelRepository.save(new CarModel(new CarBrand(7L), "A6"));
			carModelRepository.save(new CarModel(new CarBrand(7L), "A7"));

			carModelRepository.save(new CarModel(new CarBrand(8L), "3 series"));
			carModelRepository.save(new CarModel(new CarBrand(8L), "4 series"));
			carModelRepository.save(new CarModel(new CarBrand(8L), "5 series"));
			carModelRepository.save(new CarModel(new CarBrand(8L), "6 series"));

			carModelRepository.save(new CarModel(new CarBrand(9L), "Fiesta"));
			carModelRepository.save(new CarModel(new CarBrand(9L), "Mustang"));

			carModelRepository.save(new CarModel(new CarBrand(10L), "C-200"));
			carModelRepository.save(new CarModel(new CarBrand(10L), "E-200"));

			userRepository.save(new User("admin","$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));

		};
	}

}
