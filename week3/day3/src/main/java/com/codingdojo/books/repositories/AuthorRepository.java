package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
	List<Author>findAll();
	List<Author>findByNameContaining(String name);
}
