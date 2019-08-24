package com.codingdojo.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Review;
import com.codingdojo.books.repositories.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepo;
	
	public ReviewService(ReviewRepository reviewRepo) {
		this.reviewRepo = reviewRepo;
	}
	
	public List<Review> findByBook(Long bookId) {
		return reviewRepo.findByBook(bookId);
	}
	
	public Review create(Review review) {
		return reviewRepo.save(review);
	}
	
	public Review update(Review review) {
		return reviewRepo.save(review);
	}
	
	public Review findById(Long id) {
		return reviewRepo.findById(id).orElse(null);
	}
	
	public void remove(Review review) {
		reviewRepo.delete(review);
	}
	
	public void remove(Long id) {
		reviewRepo.deleteById(id);
	}
}
