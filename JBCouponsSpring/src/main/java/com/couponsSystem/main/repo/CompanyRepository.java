package com.couponsSystem.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.couponsSystem.main.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
