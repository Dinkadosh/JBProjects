package com.company.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.beans.Employee;
import com.company.beans.Job;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public List<Employee> findByName(String name);

}
