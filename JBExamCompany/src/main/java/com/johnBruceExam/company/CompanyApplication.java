package com.johnBruceExam.company;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.johnBruceExam.company.beans.Employee;
import com.johnBruceExam.company.beans.Job;
import com.johnBruceExam.company.dao.Company;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);
		System.out.println("Go!");

		Job job1 = new Job("FullStack", Date.valueOf("2019-11-10"));
		Job job2 = new Job("BackEnd", Date.valueOf("2019-11-15"));
		Job job3 = new Job("Python", Date.valueOf("2019-12-10"));
		Job job4 = new Job("JavaScript", Date.valueOf("2020-10-10"));

		List<Job> jobs1 = new ArrayList<Job>();
		jobs1.add(job1);
		jobs1.add(job2);

		List<Job> jobs2 = new ArrayList<Job>();
		jobs2.add(job3);
		jobs2.add(job4);

		Employee employee1 = new Employee("Michael", 15000, jobs1);
		Employee employee2 = new Employee("Avi", 20000, jobs2);

		Company company = ctx.getBean(Company.class);
		company.addEmployee(employee1);
		company.addEmployee(employee2);

		System.out.println(company.getEmployeeByID(2));

		System.out.println(company.getAllEmployees());

		System.out.println(company.getAllJobs());

		System.out.println(company.getEmployeesByName("Michael"));

		System.out.println(company.getJobsByEndDate(Date.valueOf("2019-11-10")));

		System.out.println(company.getJobsBetweenDates(Date.valueOf("2019-11-12"),
				Date.valueOf("2020-1-1")));
	}

}
