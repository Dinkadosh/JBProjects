package com.mongoDB.MongoDBTest.rest;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDB.MongoDBTest.beans.People;
import com.mongoDB.MongoDBTest.repo.PeopleRepositpory;

@RestController
@RequestMapping("people")
public class PeoplesController {

	@Autowired
	private PeopleRepositpory peopleRepositpory;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<People> getAllPeoples() {
		return peopleRepositpory.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public People getPeopleById(@PathVariable("id") ObjectId id) {
		return peopleRepositpory.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPeopleById(@PathVariable("id") ObjectId id, @Valid @RequestBody People people) {
		people.set_id(id);
		peopleRepositpory.save(people);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public People createPeople(@Valid @RequestBody People people) {
		people.set_id(ObjectId.get());
		peopleRepositpory.save(people);
		return people;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePeople(@PathVariable ObjectId id) {
		peopleRepositpory.delete(peopleRepositpory.findBy_id(id));
	}
}
