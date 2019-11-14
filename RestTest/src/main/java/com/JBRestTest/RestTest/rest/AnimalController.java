package com.JBRestTest.RestTest.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animal")
public class AnimalController {

	@PostMapping("add")
	public String addNewAnimal(@RequestParam(name = "name") String name) {
		return name + " was added";
	}
	
	@DeleteMapping("delete/{name}")
	public String deleteAnumal(@PathVariable(name = "name") String name) {
		return name + " was deleted";
	}
	
	@PutMapping("update")
	public String updateAnimal(@RequestParam(name = "oldName") String oldName, @RequestParam(name = "newName") String newName) {
		return oldName + " was update into " + newName;
	}
	
	@GetMapping("getAll")
	public String getAll() {
		return "bhla bhla bhla";
	}
}
