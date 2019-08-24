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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String username;
	
	
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@Transient
	private String passwordConfirmation;
	

	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<LikedReview> likedReviews = new ArrayList<LikedReview>();
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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
