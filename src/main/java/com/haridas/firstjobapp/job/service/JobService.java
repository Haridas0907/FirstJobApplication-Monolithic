package com.haridas.firstjobapp.job.service;

import java.util.List;

import com.haridas.firstjobapp.model.Job;

public interface JobService {
	List<Job> findAll();

	void createJob(Job job);

	Job getJobById(Long id);

	boolean deleteJobById(Long id);

	boolean updateJob(Long id, Job updatedJob);

}