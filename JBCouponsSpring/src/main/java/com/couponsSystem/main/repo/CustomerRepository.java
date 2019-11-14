package com.couponsSystem.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couponsSystem.main.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
