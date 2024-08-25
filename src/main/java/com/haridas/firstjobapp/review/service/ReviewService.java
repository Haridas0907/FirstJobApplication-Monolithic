package com.haridas.firstjobapp.review.service;

import java.util.List;

import com.haridas.firstjobapp.review.model.Review;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);

	boolean addReview(Long companyId, Review review);

	Review getReview(Long companyid, Long reviewId);

	boolean updateReview(Long companyId, Long reviewId, Review updatedview);

	boolean deleteReview(Long companyId, Long reviewId);
}
