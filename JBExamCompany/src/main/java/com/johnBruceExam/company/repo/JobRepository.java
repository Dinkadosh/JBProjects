package com.johnBruceExam.company.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnBruceExam.company.beans.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	public List<Job> findJobsByEndDate(Date date);
	
	public List<Job> findByEndDateBetween(Date startDate, Date endDate);
}
