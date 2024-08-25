package com.haridas.firstjobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haridas.firstjobapp.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long> {

}
