package com.geek.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
private int movieId;
private String movieName;
private String genre;
private String language;
public Movie() {
	// TODO Auto-generated constructor stub
}
public Movie(int movieId, String movieName, String genre, String language) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.genre = genre;
	this.language = language;
}

public int getMovieId() {
	return movieId;
}

public void setMovieId(int movieId) {
	this.movieId = movieId;
}

public String getMovieName() {
	return movieName;
}

public void setMovieName(String movieName) {
	this.movieName = movieName;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

}
