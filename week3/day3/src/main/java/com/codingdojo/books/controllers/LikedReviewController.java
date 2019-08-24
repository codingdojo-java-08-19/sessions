package com.codingdojo.books.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.books.models.LikedReview;
import com.codingdojo.books.services.LikedReviewService;

@Controller
@RequestMapping("/liked_reviews")
public class LikedReviewController {
	private final LikedReviewService likeService;
	
	public LikedReviewController(LikedReviewService likeService) {
		this.likeService = likeService;
	}
	
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("liked_review") LikedReview like, BindingResult result) {
		final String page = "redirect:/books";
		
		if (result.hasErrors()) {
			return page;	
		}
		
		likeService.create(like);
		
		return page;
	}
}
