package com.geek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geek.entity.Book;
import com.geek.entity.Genre;

public interface BookRepository extends JpaRepository<Book, Integer> {
	//in query we will give param by :paramname
	//SQL query
	@Query(value = "select * from Book  where genre= :g",nativeQuery = true)
	List<Book> searchByGenre(@Param("g")  String genre);
	//query methods
	//start by findBy<<field name>>
	List<Book> findByBookName(String bookName);
	//@Query(value = "select b from Book b where genre= :g") //jpql
	@Query(name = "searchBook")
	List<Book> searchByGenreByJqpl(@Param("g") Genre genre);
}
