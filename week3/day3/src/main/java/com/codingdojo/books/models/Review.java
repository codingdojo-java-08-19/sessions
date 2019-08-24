package com.codingdojo.books.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reviews")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=10)
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="review", fetch=FetchType.LAZY)
	private List<LikedReview> likedReviews = new ArrayList<LikedReview>();
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Review() {}

	public Long getId() {
		return id;
	}
	
	public boolean hasUserLiked(Long userId) {
		for (LikedReview like : likedReviews) {
			if (like.getUser().getId().equals(userId)) {
				return true;
			}
		}
		
		return false;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<LikedReview> getLikedReviews() {
		return likedReviews;
	}

	public void setLikedReviews(List<LikedReview> likedReviews) {
		this.likedReviews = likedReviews;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
}
