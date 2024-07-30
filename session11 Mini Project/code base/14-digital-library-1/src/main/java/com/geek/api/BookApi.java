package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.repository.BookRepository;
import com.geek.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookApi {
	@Autowired
private BookService bookService;
	@PostMapping("/authour")
	public Authour addNewAuthour( @Valid @RequestBody Authour authour) {
		return bookService.addAuthour(authour);
	}
	
	@PostMapping
	public Book addNewBook( @RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
	}
	@GetMapping("/search/genre")
	public List<Book> searchByGenre(@RequestParam("genre")  String genre){
		return bookService.searchByGenre(genre);
	}
	
	@GetMapping("/search/book")
	public List<Book> searchByBook(@RequestParam("book")  String book){
		return bookService.searchByBookName(book);
	}
}

