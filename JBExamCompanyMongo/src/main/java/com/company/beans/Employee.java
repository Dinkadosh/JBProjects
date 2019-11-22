package com.company.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
	
	@Id
	private String id;
	private String name;
	private double salary;
	private List<Job> jobs = new ArrayList<Job>();

	public Employee() {
	}

	public Employee(String name, double salary, List<Job> jobs) {
		this.name = name;
		this.salary = salary;
		this.jobs = jobs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public void addJob(Job job) {
		if (job != null) {
			jobs.add(job);
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", jobs=" + jobs + "]";
	}
}
