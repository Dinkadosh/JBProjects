package com.mvc.JBMVCTest.rest;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.JBMVCTest.beans.Person;

@RestController
public class MyController {

	@Autowired
	private Collection<Person> people;

	@PostConstruct
	public void init() {
		Person p1 = new Person();
		p1.setName("Michael");
		p1.setAge(32);
		people.add(p1);

		Person p2 = new Person();
		p2.setName("Ira");
		p2.setAge(31);
		people.add(p2);
	}

	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	@CrossOrigin
	public String greet(@RequestParam(value = "name", defaultValue = "nobody") String name) {
		return "Hello " + name + "!!!";
	}

	@GetMapping("/sum/{num1}/{num2}")
	@CrossOrigin
	public String num(@PathVariable int num1, @PathVariable int num2) {
		return num1 + num2 + "";
	}

	@RequestMapping("/people")
	@CrossOrigin
	public Collection<Person> getPeople() {
		return people;
	}

	@RequestMapping(value = "/handle", consumes = "application/json", method = RequestMethod.POST)
	@CrossOrigin
	public Person handlePerson(@RequestBody Person p) {
		p.setName(p.getName() + " (handled....)");
		people.add(p);
		return p;
	}
	
	@RequestMapping("/person/{name}/{age}")
    public ResponseEntity<?> getPerson(@PathVariable("name")String name,@PathVariable("age") int age){
        if(age<0||age>120){
            return new ResponseEntity<String>("wrong age value...",HttpStatus.BAD_REQUEST);
        }
        Person p=new Person();
        p.setName(name);
        p.setAge(age);
        return new ResponseEntity<Person>(p,HttpStatus.OK);
    }
}
