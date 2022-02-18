package com.sensedia.rampup.store.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sensedia.rampup.store.entities.Customer;
import com.sensedia.rampup.store.services.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerResource {
	
	@Autowired
	private CustomerService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		
		List<Customer> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id) {
		System.out.println("####");
		System.out.println(id);
		Customer obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Customer obj) {
		obj = service.save(obj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
