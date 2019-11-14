package com.JBRestTest.RestTest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

	@PostMapping("add/{name}")
	public String addPerson(@PathVariable(name = "name") String name) {
		return name + " was added";
	}

	@PostMapping("add")
	public String addPerson2(@RequestParam(name = "name") String name) {
		return name + " was added";
	}

	@DeleteMapping("delete/{name}")
	public String deletePerson(@PathVariable(name = "name") String name) {
		return name + " was deleted";
	}
}
