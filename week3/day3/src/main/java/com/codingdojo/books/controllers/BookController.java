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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.books.models.Author;
import com.codingdojo.books.models.Book;
import com.codingdojo.books.models.LikedReview;
import com.codingdojo.books.models.Review;
import com.codingdojo.books.services.AuthorService;
import com.codingdojo.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private final BookService bookService;
	private final AuthorService authorService;
	
	public BookController(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
	
	@GetMapping("")
//	@RequestMapping("")
	public String index(Model model) {
		List<Book> books = bookService.findAllBooks();
		
		System.out.println(books);
		
		model.addAttribute("books", books);
		
		return "books/index.jsp";
	}
	@PostMapping("")
//	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		final String page = result.hasErrors() ? "books/new.jsp" : "redirect:/books";
		
		if (!result.hasErrors()) {			
			bookService.create(book);
		}
			
		
		return page;
	}
	
//	/books/5
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("review") Review review, @ModelAttribute("liked_review") LikedReview likedReview, Model model, HttpSession session) {
		Book book = bookService.findById(id);
		
		final Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("book", book);
		model.addAttribute("userId", userId);
		
		System.out.println("user id is " + userId);
		
		return "books/show.jsp";
	}
	
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
		final List<Author> authors = authorService.findAllAuthors();
		
		model.addAttribute("authors", authors);
		
		return "books/new.jsp";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		final Book book = bookService.findById(id);
		final List<Author> authors = authorService.findAllAuthors();
		
		model.addAttribute("book", book);
		model.addAttribute("authors", authors);
		
		return "books/edit.jsp";
		
	}
	
	@PutMapping("/{id}")
//	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		final Boolean hasErrors = result.hasErrors();
		final String page = hasErrors ? "books/edit.jsp" : "redirect:/books";
		
		
		if (!hasErrors) {
			bookService.update(book);
		}
		
		return page;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookService.removeBookById(id);
		
		return "redirect:/books";
	}
}
