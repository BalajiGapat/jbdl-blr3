package com.geek.service;

import java.util.List;

import com.geek.entity.Movie;

public interface MovieService {
List<Movie> allMovies();
Movie searchById(int movieId);
Movie updateMovie(Movie m, int movieId);
void deleteMovie(int movieId);
List<Movie> addNewMovie(Movie m);
}
