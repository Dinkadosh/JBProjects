package com.company;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.company.beans.Employee;
import com.company.beans.Job;
import com.company.dao.Company;

@SpringBootApplication
public class JbExamCompanyMongoApplication {
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(JbExamCompanyMongoApplication.class, args);
		System.out.println("Go!");
		
		Job job1 = new Job("FullStack", sdf.parse("20/12/2019"));
		Job job2 = new Job("BackEnd", sdf.parse("20/03/2020"));
		Job job3 = new Job("Python", sdf.parse("29/11/2019"));
		Job job4 = new Job("JavaScript", sdf.parse("05/02/2020"));

		List<Job> jobs1 = new ArrayList<Job>();
		jobs1.add(job1);
		jobs1.add(job2);

		List<Job> jobs2 = new ArrayList<Job>();
		jobs2.add(job3);
		jobs2.add(job4);

		Employee employee1 = new Employee("Michael", 15000, jobs1);
		Employee employee2 = new Employee("Avi", 20000, jobs2);

		Company company = ctx.getBean(Company.class);
		company.resetDB();
		company.addEmployee(employee1);
		company.addEmployee(employee2);

		System.out.println(company.getEmployeeByID(employee1.getId()));

		System.out.println(company.getAllEmployees());

		System.out.println(company.getEmployeesByName("Michael"));
		
		System.out.println(company.getAllJobs());
		
		System.out.println(company.getJobsByEndDate(sdf.parse("20/12/2019")));

		System.out.println(company.getJobsBetweenDates(sdf.parse("25/11/2019"),
				sdf.parse("25/12/2019")));
	}

}
