package com.haridas.firstjobapp.job.controller;

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

import com.haridas.firstjobapp.job.service.JobService;
import com.haridas.firstjobapp.model.Job;

@RestController
@RequestMapping("/jobs")
public class JobController {
	@Autowired
	private JobService jobService;
	

	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> findALL() {
		return ResponseEntity.ok(jobService.findAll());

	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job Added Successfully", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job = jobService.getJobById(id);
		if (job != null)
			return new ResponseEntity<>(job, HttpStatus.OK);
		return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id) {
		boolean deleted = jobService.deleteJobById(id);
		if (deleted)
			return new ResponseEntity<>("Job Deleted Sucessfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
		boolean updated = jobService.updateJob(id, updatedJob);
		if (updated)
			return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
