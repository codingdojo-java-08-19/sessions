package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{
	List<Review> findByBook(Long bookId);
}
