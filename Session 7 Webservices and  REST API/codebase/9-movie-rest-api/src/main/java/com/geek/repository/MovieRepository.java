package com.geek.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.geek.entity.Movie;

@Component
public class MovieRepository {
List<Movie> movies= new ArrayList<>();
{
	//instance block
	Movie m1=new Movie(101, "Matrix", "SCIFI", "ENG");
	Movie m2=new Movie(102, "MI", "Action", "ENG");
	Movie m3=new Movie(103, "Terminator", "Action/SCIFI", "ENG");
	Movie m4=new Movie(104, "Speed", "Action", "ENG");
	Movie m5=new Movie(105, "Fast and furious", "Action", "ENG");
	movies.add(m1);
	movies.add(m2);
	movies.add(m3);
	movies.add(m4);
	movies.add(m5);
}

public List<Movie> getAllMovies(){
	return movies;
}
}
