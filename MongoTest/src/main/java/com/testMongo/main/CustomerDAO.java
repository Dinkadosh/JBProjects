package com.testMongo.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	@Autowired
	private CustomerRepository repository;
	
	public void resetDB() {
		repository.deleteAll();
	}
	
	public void addCustomer(Customer customer) {
		repository.save(customer);
	}
	
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	public List<Customer> findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}
	
	public List<Customer> findByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}
}
