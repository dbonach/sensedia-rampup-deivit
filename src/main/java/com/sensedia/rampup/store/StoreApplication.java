package com.sensedia.rampup.store;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sensedia.rampup.store.entities.Customer;
import com.sensedia.rampup.store.repositories.CustomerRepository;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer c1 = new Customer("Arthur", "arthur@gmai.com");
		Customer c2 = new Customer("Deivit", "deivit@gmail.com");
		Customer c3 = new Customer("Joao", "joao@gmail.com");
		
		customerRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}
