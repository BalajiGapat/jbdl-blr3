package com.geek.service;

import com.geek.entity.Movie;

public interface MovieService {
 public void addNewMovie(Movie m);
 
 public Movie searchMovie(int id);
}
