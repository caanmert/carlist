package com.canmert.carlist;

import com.canmert.carlist.model.User;
import com.canmert.carlist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarlistApplication.class, args);
	}

}

