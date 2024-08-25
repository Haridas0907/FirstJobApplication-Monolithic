package com.haridas.firstjobapp.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haridas.firstjobapp.review.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long companyId);

}