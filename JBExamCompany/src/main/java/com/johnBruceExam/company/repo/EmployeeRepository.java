package com.johnBruceExam.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnBruceExam.company.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findEmployeesByName(String name);
}
