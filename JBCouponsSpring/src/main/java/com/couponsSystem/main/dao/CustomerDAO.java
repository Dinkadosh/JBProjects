package com.couponsSystem.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couponsSystem.main.beans.Customer;
import com.couponsSystem.main.repo.CustomerRepository;

@Repository
public class CustomerDAO {
	
	@Autowired
	private CustomerRepository repo;
	
	public void addCustomer(Customer customer) {
		if (customer != null) {
			repo.save(customer);
		}
	}
	
	public void deleteCustomer(Customer customer) {
		if (customer != null) {
			repo.delete(customer);
		}
	}
	
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}
}
