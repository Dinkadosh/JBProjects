package com.mongoDB.MongoDBTest.beans;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Peoples")
public class People {
	@Id
	private ObjectId _id;

	@Indexed
	private String firstName;
	@Indexed
	private String lastName;

	public People(ObjectId _id, String firstName, String lastName) {
		super();
		this._id = _id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public People() {
		super();
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
