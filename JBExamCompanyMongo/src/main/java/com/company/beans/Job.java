package com.company.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Job {

	private String description;
	private Date endDate;

	public Job() {
	}

	public Job(String description, Date endDate) {
		this.description = description;
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Job [description=" + description + ", endDate=" + endDate + "]";
	}
}
