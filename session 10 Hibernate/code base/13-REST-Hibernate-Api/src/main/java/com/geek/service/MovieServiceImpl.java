package com.geek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.geek.entity.Movie;
import com.geek.repository.MovieRepository;
@Component
@Transactional
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRep;
	@Override
	public void addNewMovie(Movie m) {
		//movieRep.addMovie(m);
		movieRep.save(m);
	}
	@Override
	public Movie searchMovie(int id) {
		Movie m=movieRep.findById(id).get();
		return m;
	}
}
