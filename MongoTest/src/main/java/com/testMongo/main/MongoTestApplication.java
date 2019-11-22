package com.testMongo.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MongoTestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MongoTestApplication.class, args);
		System.out.println("Go!");
		
		CustomerDAO customerDAO = ctx.getBean(CustomerDAO.class);
		
		customerDAO.resetDB();
		
		customerDAO.addCustomer(new Customer("Alice", "Smith"));
		customerDAO.addCustomer(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerDAO.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerDAO.findByFirstName("Alice"));
		System.out.println();


		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerDAO.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}

}
