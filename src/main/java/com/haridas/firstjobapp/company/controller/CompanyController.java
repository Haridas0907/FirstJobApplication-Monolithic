package com.haridas.firstjobapp.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haridas.firstjobapp.company.model.Company;
import com.haridas.firstjobapp.company.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getJobById(@PathVariable Long id) {
		Company company = companyService.getCompanyById(id);
		if (company != null)
			return new ResponseEntity<>(company, HttpStatus.OK);
		return new ResponseEntity<>(company, HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
		boolean updated = companyService.updateCompany(id, company);
		if (updated)
			return new ResponseEntity<>("Company Updated Sucessfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company  Succesfully Created", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		boolean isDeleted = companyService.deleteCompanyById(id);
		if (isDeleted)
			return new ResponseEntity<>("Company  Sucessfully Deleted", HttpStatus.OK);
		return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
	}

}
