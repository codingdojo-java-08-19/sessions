package com.codingdojo.books.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.books.models.Author;
import com.codingdojo.books.services.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("")
	public String index(Model model) {
		List<Author> authors = authorService.findAllAuthors();
		
		model.addAttribute("authors", authors);
		
		return "authors/index.jsp";
	}
	
	@GetMapping("/new")
	public String newAuthor(@ModelAttribute("author") Author author, HttpSession session) {
		final Long userId = (Long) session.getAttribute("userID");
		
		if (userId == null) {
			return "redirect:/authors";
		}
		
		
		return "authors/new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("author") Author author, BindingResult result) {
		final String page = result.hasErrors() ? "authors/new.jsp" : "redirect:/authors";
		
		if(!result.hasErrors()) {
			authorService.create(author);
		}
		
		return page;
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Author author = authorService.findById(id);
		
		final String page = author == null ? "redirect:/authors" : "authors/show.jsp";
		
		model.addAttribute("author", author);
		
		return page;
	}
}












