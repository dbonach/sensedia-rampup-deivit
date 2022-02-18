package com.sensedia.rampup.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensedia.rampup.store.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
