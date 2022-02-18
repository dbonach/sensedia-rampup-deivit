package com.sensedia.rampup.store.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensedia.rampup.store.entities.Customer;
import com.sensedia.rampup.store.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer findById(Integer id) {
		
		Optional<Customer> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(id, Customer.class.getName()));
	}
	
	public List<Customer> findAll() {
		
		return repo.findAll();
	}
	
	public Customer save(Customer obj) {
		
		obj.setId(null);
		obj = repo.save(obj);
		
		return obj;
	}
}
