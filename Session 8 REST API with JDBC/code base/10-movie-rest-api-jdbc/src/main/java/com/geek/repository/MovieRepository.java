package com.geek.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geek.entity.Movie;

@Component
public class MovieRepository {
	@Autowired
private DBConnection dbConnection;
public List<Movie> getAllMovies(){
	return null;
}
public Movie searchByMovieId(int id) {
	  Movie m=new Movie();
	Connection con=dbConnection.getConnection();
	String sql="select * from movie where movieId=?";
	PreparedStatement pstmt;
	try {
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		//for only select queries
	  ResultSet rs=	pstmt.executeQuery();
	  if(rs.next()) {
		
		  int mid=rs.getInt("movieId"); //reading the col val by name
		  String mName=rs.getString("movieName");
		  String lang=rs.getString("language");
		  String genre=rs.getString("genre");
		  m.setMovieId(mid);
		  m.setGenre(genre);
		  m.setLanguage(lang);
		  m.setMovieName(mName);
	  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return m;
}
public Movie addMovie(Movie m) {
	Connection con=dbConnection.getConnection();
	String sql="insert into movie values(?,?,?,?)";
	try {
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, m.getMovieId());
		pstmt.setString(2, m.getMovieName());
		pstmt.setString(3, m.getGenre());
		pstmt.setString(4, m.getLanguage());
		//insert/update/delete queries ....
		pstmt.executeUpdate();//fires the query in the database
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return m;
}
}
