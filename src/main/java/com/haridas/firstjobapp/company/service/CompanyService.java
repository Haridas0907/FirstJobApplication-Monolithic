package com.haridas.firstjobapp.company.service;

import java.util.List;

import com.haridas.firstjobapp.company.model.Company;

public interface CompanyService {
	List<Company> getAllCompanies();

	boolean updateCompany(Long id, Company company);

	
	void createCompany(Company company);

	
	  boolean deleteCompanyById(Long id);
	  
	 Company getCompanyById(Long id);
	 
}
