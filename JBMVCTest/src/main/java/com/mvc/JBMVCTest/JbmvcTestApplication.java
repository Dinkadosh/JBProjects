package com.mvc.JBMVCTest;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.mvc.JBMVCTest.beans.Person;

@SpringBootApplication
public class JbmvcTestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JbmvcTestApplication.class, args);
		System.out.println("Go!");
		
		RestTemplate client=new RestTemplate();
		System.out.println(client.getForObject("http://localhost:8080/greet?name=Moshe", String.class));
	}
	
	@Bean
	public Collection<Person> people() {
		return new ArrayList<Person>();
	}

}
