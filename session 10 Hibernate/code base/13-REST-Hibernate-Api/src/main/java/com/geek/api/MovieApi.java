package com.geek.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.entity.Movie;
import com.geek.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {
	@Autowired
	private MovieService movieService;
   @PostMapping
	public Movie addMovie(@RequestBody Movie m) {
	   m.setReleaseDate(LocalDateTime.now());
		movieService.addNewMovie(m);
	   return m;
	}
   
   @GetMapping("/{mid}")
	public Movie searchMovie(@PathVariable  int mid) {
		Movie m=movieService.searchMovie(mid);
	   return m;
	}
}
