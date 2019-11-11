package com.johnBruceExam.company.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "employees")
public class Employee {

	private long id;
	private String name;
	private double salary;
	private Collection<Job> jobs = new ArrayList<Job>();

	public Employee() {
	}

	public Employee(String name, double salary, List<Job> jobs) {
		this.name = name;
		this.salary = salary;
		this.jobs = jobs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public Collection<Job> getJobs() {
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
