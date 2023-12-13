package com.example.custumerservice;


import com.example.custumerservice.entities.Customer;

import com.example.custumerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Meliodas").email("meliodas@gmail.com").build(),
					Customer.builder().name("Elizabeth").email("elizabeth@gmail.com").build(),
					Customer.builder().name("Ban").email("ban@gmail.com").build()
			));
				customerRepository.findAll().forEach(System.out::println);
		};
	}
}
