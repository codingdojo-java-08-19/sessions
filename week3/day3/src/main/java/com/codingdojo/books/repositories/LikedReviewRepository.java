package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.LikedReview;

@Repository
public interface LikedReviewRepository extends CrudRepository<LikedReview, Long>{
	List<LikedReview> findByReview(Long reviewId);
	List<LikedReview> findByUser(Long userId);
}
