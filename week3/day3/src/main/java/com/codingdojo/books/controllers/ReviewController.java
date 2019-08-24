package com.codingdojo.books.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.models.Review;
import com.codingdojo.books.services.BookService;
import com.codingdojo.books.services.ReviewService;

@Controller
@RequestMapping("/books/{bookId}/reviews")
public class ReviewController {
	private final ReviewService reviewService;
	private final BookService bookService;
	
	public ReviewController(ReviewService reviewService, BookService bookService) {
		this.reviewService = reviewService;
		this.bookService = bookService;
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("review") Review review, BindingResult result, @PathVariable("bookId") Long bookId, Model model, RedirectAttributes redirectAttrs) {
		final String page = result.hasErrors() ? "books/show.jsp" : "redirect:/books/" + bookId;
		
		if (result.hasErrors()) {
			final Book book = bookService.findById(bookId);
			model.addAttribute("book", book);
		} else {
			reviewService.create(review);
			redirectAttrs.addFlashAttribute("success", "Successfully created a new review");
		}
		
		return page;
	}
	
}
