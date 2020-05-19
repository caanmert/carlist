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

			/*carRepository.save(new Car("Bmw", "3 series", 2006));
			carRepository.save(new Car("Bmw", "5 series", 2003));
			carRepository.save(new Car("Audi", "a4", 2009));
			carRepository.save(new Car("Toyota", "Corolla", 2002));
			carRepository.save(new Car("Ford", "Fiesta", 2012));
			carRepository.save(new Car("Ford", "Mustang", 2012));
			carRepository.save(new Car("Ford", "Mustang", 2012));*/

			carBrandRepository.save(new CarBrand( "Audi"));
			carBrandRepository.save(new CarBrand( "BMW"));
			carBrandRepository.save(new CarBrand( "Ford"));
			carBrandRepository.save(new CarBrand("Mercedes-Benz"));
			carBrandRepository.save(new CarBrand("Opel"));

			carModelRepository.save(new CarModel(new CarBrand(1L), "A3"));
			carModelRepository.save(new CarModel(new CarBrand(1L), "A4"));
			carModelRepository.save(new CarModel(new CarBrand(1L), "A5"));
			carModelRepository.save(new CarModel(new CarBrand(1L), "A6"));
			carModelRepository.save(new CarModel(new CarBrand(1L), "A7"));

			carModelRepository.save(new CarModel(new CarBrand(2L), "3 series"));
			carModelRepository.save(new CarModel(new CarBrand(2L), "4 series"));
			carModelRepository.save(new CarModel(new CarBrand(2L), "5 series"));
			carModelRepository.save(new CarModel(new CarBrand(2L), "6 series"));

			carModelRepository.save(new CarModel(new CarBrand(3L), "Fiesta"));
			carModelRepository.save(new CarModel(new CarBrand(3L), "Mustang"));

			carModelRepository.save(new CarModel(new CarBrand(4L), "C-200"));
			carModelRepository.save(new CarModel(new CarBrand(4L), "E-200"));

			userRepository.save(new User("admin","sds","$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));

		};
	}

}
