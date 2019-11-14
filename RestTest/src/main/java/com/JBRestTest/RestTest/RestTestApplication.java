package com.JBRestTest.RestTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestTestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestTestApplication.class, args);
		System.out.println("Go!");
	}

}
