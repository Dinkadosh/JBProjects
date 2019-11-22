package com.mongoDB.MongoDBTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MongoDbTestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MongoDbTestApplication.class, args);
		System.out.println("Go!");
	}

}
