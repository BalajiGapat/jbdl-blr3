package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
