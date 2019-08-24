package com.codingdojo.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.LikedReview;
import com.codingdojo.books.repositories.LikedReviewRepository;

@Service
public class LikedReviewService {
	private final LikedReviewRepository likedRepo;
	
	public LikedReviewService(LikedReviewRepository likedRepo) {
		this.likedRepo = likedRepo;
	}
	
	public List<LikedReview> findByReview(Long reviewId) {
		return likedRepo.findByReview(reviewId);
	}
	
	public List<LikedReview> findByUser(Long userId) {
		return likedRepo.findByUser(userId);
	}
	
	public LikedReview create(LikedReview liked) {
		return likedRepo.save(liked);
	}
}
