package com.mongoDB.MongoDBTest.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;


import com.mongoDB.MongoDBTest.beans.People;

public interface PeopleRepositpory extends MongoRepository<People, String> {
	List<People> findByLastName(@Param("name") String name);
	
	People findBy_id(ObjectId _id);
}
