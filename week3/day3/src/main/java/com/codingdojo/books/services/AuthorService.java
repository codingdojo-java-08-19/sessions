package com.codingdojo.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Author;
import com.codingdojo.books.repositories.AuthorRepository;

@Service
public class AuthorService {
	private final AuthorRepository authorRepo;
	
	public AuthorService(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	public List<Author> findAllAuthors() {
		return authorRepo.findAll();
	}
	
	public Author findById(Long id) {
		return authorRepo.findById(id).orElse(null);
	}
	
	public List<Author> findAuthorsByName(String name) {
		return authorRepo.findByNameContaining(name);
	}
	
	public Author create(Author author) {
		return authorRepo.save(author);
	}
	
	public Author create(String name, Integer age) {
		Author author = new Author();
		
		author.setAge(age);
		author.setName(name);
		
		return create(author);
	}
	
	public Author update(Author author) {
		return authorRepo.save(author);
	}
	
	public Author update(Long id, String name, Integer age) {
		Author author = findById(id);
		
		author.setAge(age);
		author.setName(name);
		
		return update(author);
	}
	
	public void remove(Author author) {
		remove(author.getId());
	}
	
	public void remove(Long id) {
		authorRepo.deleteById(id);
	}
}
