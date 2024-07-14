package com.geek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.entity.Movie;
import com.geek.service.MovieService;

@RestController //indicates this class is a REST api class
@RequestMapping("api/movies")
public class MovieApi {
	@Autowired
	 private MovieService movieService;
	
	//@GetMapping//(produces="text/html")//MIME
	public String test() {
		return "<font size=10 color=blue>Hello</font>";
	}
	@GetMapping("/search/genre")
	public List<Movie> searchByGenre( @RequestParam("genre") String genre){
		 List<Movie> movies=movieService.allMovies();
		 List<Movie> filteredMovies=
				 movies.stream().filter(p->p.getGenre().equals(genre)).toList();
		return filteredMovies;
	}
	@GetMapping("/sample")
	public Movie sampleData() {
		return new Movie(101, "Matrix", "SCIFI", "ENGLISH");
	}
	@GetMapping
	public  ResponseEntity<List<Movie>> allMovies(){
		 List<Movie> movies=movieService.allMovies();
		 if (movies==null) {
			return new ResponseEntity<List<Movie>>(movies,HttpStatusCode.valueOf(204)); 
		 }
		 return new ResponseEntity<List<Movie>>(movies,HttpStatusCode.valueOf(200)); 
	}
	@GetMapping("/{movieId}")
	public Movie searchById(@PathVariable int movieId) {
		return movieService.searchById(movieId);
	}
	@PostMapping(consumes ={"application/xml","application/json"},produces = "application/json")
	public List<Movie> addNewMovie( @RequestBody Movie m){
		return movieService.addNewMovie(m);
	}
	
	@DeleteMapping("/{movieId}")
	public  ResponseEntity<?> removeMovie(@PathVariable int movieId) {
		movieService.deleteMovie(movieId);
		return new ResponseEntity(null, HttpStatusCode.valueOf(202));
	}
}
