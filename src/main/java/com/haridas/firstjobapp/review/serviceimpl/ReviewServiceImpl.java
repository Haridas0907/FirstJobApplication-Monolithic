package com.haridas.firstjobapp.review.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haridas.firstjobapp.company.model.Company;
import com.haridas.firstjobapp.company.service.CompanyService;
import com.haridas.firstjobapp.review.model.Review;
import com.haridas.firstjobapp.review.repository.ReviewRepo;
import com.haridas.firstjobapp.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	private CompanyService companyService;;

	public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyService companyService) {
		super();
		this.reviewRepo = reviewRepo;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if (company != null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Review getReview(Long companyid, Long reviewId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyid);
		return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
		if (companyService.getCompanyById(companyId) != null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepo.save(updatedReview);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if (companyService.getCompanyById(companyId) != null && reviewRepo.existsById(reviewId)) {
			Review review = reviewRepo.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(companyId, company);
			reviewRepo.deleteById(reviewId);
			return true;

		} else {
			return false;

		}
	}

}
