package com.geek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geek.entity.Movie;
import com.geek.exceptions.ApplicationException;
import com.geek.repository.MovieRepository;

import jakarta.annotation.PostConstruct;
@Component
public class MovieServiceImpl implements MovieService {
	@Autowired
   private MovieRepository movieRep;
	
	@Override
	public List<Movie> allMovies() {
		return movieRep.getAllMovies();
		//return null;
	}

	@Override
	public Movie searchById(int movieId) {
		Movie m= movieRep.searchByMovieId(movieId);
		if(m==null || m.getMovieId()==0)
			throw new ApplicationException("Movie id "+movieId+"  is not found");
		return m;
	}

	@Override
	public Movie updateMovie(Movie m, int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		List<Movie> movies=	movieRep.getAllMovies();
		movies.removeIf(p->p.getMovieId()==movieId);
	}

	@Override
	public Movie addNewMovie(Movie m) {
	return movieRep.addMovie(m);
	}

}
