package com.company.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.beans.Employee;
import com.company.beans.Job;
import com.company.repo.EmployeeRepository;

@Repository
public class Company {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void resetDB() {
		employeeRepository.deleteAll();
	}

	public void addEmployee(Employee employee) {
		if (employee != null) {
			employeeRepository.save(employee);
		}
	}

	public Optional<Employee> getEmployeeByID(String id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findByName(name);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public List<Job> getAllJobs() {
		List<Job> jobs = new ArrayList<Job>();
		employeeRepository.findAll().stream().forEach((e) -> jobs.addAll(e.getJobs()));
		return jobs;
	}

	public List<Job> getJobsByEndDate(Date date) {
		return getAllJobs().stream().filter((j) -> j.getEndDate().equals(date)).collect(Collectors.toList());
	}

	public List<Job> getJobsBetweenDates(Date startDate, Date endDate) {
		return getAllJobs().stream().filter((j) -> (j.getEndDate().after(startDate)&&j.getEndDate().before(endDate))).collect(Collectors.toList());
	}
}
