package com.haridas.firstjobapp.company.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haridas.firstjobapp.comapny.repository.CompanyRepo;
import com.haridas.firstjobapp.company.model.Company;
import com.haridas.firstjobapp.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepo companyRepo;

	@Override
	public List<Company> getAllCompanies() {

		return companyRepo.findAll();
	}

	@Override
	public boolean updateCompany(Long id, Company company) {
		Optional<Company> companyOptional = companyRepo.findById(id);
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get();
			companyToUpdate.setName(company.getName());
			companyToUpdate.setJobs(company.getJobs());
			companyToUpdate.setDescription(company.getDescription());

			companyRepo.save(company);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);

	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepo.existsById(id)) {
			companyRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepo.findById(id).orElse(null);
	}

}
