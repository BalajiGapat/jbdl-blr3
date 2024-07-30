package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Reviews {
	@Id
private int revId;
private String reviewerName;
private String review;
private float ratings;
@ManyToOne
@JoinColumn(name = "movie_id")
private Movie movie;
}
