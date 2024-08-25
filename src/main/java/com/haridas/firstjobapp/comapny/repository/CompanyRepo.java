package com.haridas.firstjobapp.comapny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haridas.firstjobapp.company.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}

