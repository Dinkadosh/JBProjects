package com.johnBruceExam.company.beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "jobs")
public class Job {

	private long id;
	private String description;
	//@Basic
	private Date endDate;

	public Job() {
	}

	public Job(String description, Date endDate) {
		this.description = description;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
//		if (endDate != null) {
//	        this.endDate = new Date(endDate.getTime());
//	    } else {
//	        this.endDate = null;
//	    }
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", description=" + description + ", endDate=" + endDate + "]";
	}

}
