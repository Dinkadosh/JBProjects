package com.johnBruceExam.company.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnBruceExam.company.beans.Employee;
import com.johnBruceExam.company.beans.Job;
import com.johnBruceExam.company.repo.EmployeeRepository;
import com.johnBruceExam.company.repo.JobRepository;

@Repository
public class Company {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) {
		if (employee != null) {
			employeeRepository.save(employee);
		}
	}
	
	public Optional<Employee> getEmployeeByID(long id) {
		return employeeRepository.findById(id);
	}
	
	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findEmployeesByName(name);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}
	
	public List<Job> getJobsByEndDate(Date date) {
		return jobRepository.findJobsByEndDate(date);
	}
	
	public List<Job> getJobsBetweenDates(Date startDate, Date endDate) {
		return jobRepository.findByEndDateBetween(startDate, endDate);
	}
}
