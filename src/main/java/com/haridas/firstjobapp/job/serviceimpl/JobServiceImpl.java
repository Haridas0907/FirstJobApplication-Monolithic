package com.haridas.firstjobapp.job.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haridas.firstjobapp.job.service.JobService;
import com.haridas.firstjobapp.model.Job;
import com.haridas.firstjobapp.repository.JobRepo;



@Service
public class JobServiceImpl implements JobService {
	// private List<Job> jobs = new ArrayList<>();
	@Autowired
	JobRepo jobRepo;

	public JobServiceImpl(JobRepo jobRepo) {
		super();
		this.jobRepo = jobRepo;
	}

	// private Long nextId = 1L; // Increament Id

	@Override
	public List<Job> findAll() {
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		// job.setId(nextId++);
		jobRepo.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepo.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepo.save(job);
			return true;

		}

		return false;
	}

}
