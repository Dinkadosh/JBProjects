package com.couponsSystem.main.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.couponsSystem.main.beans.Company;
import com.couponsSystem.main.repo.CompanyRepository;

@Repository
public class CompanyDAO {
	
	@Autowired
	private CompanyRepository repo;
	
	public void addCompany(Company company) {
		if (company != null) {
			repo.save(company);
		}
	}
	
	public void deleteCompany(Company company) {
		if (company != null) {
			repo.delete(company);
		}
	}
	
	public List<Company> getAllCompanies() {
		return repo.findAll();
	}
}
