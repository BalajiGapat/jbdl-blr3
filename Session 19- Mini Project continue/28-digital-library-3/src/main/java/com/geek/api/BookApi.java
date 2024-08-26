package com.geek.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.repository.BookRepository;
import com.geek.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookApi {
	@Autowired
private BookService bookService;
	
	@PostMapping("/authour")
	@PreAuthorize("hasAuthority('Admin')") //single role
	public Authour addNewAuthour( @Valid @RequestBody Authour authour) {
		return bookService.addAuthour(authour);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('Admin')") //single role
	public Book addNewBook( @RequestBody BookDto bookDto,Principal p) {
		System.out.println(p.getName());
		return bookService.addBook(bookDto);
	}
	@GetMapping("/search/genre")
	@PreAuthorize("hasAnyAuthority('User','Admin')") //multiple roles
	public List<Book> searchByGenre(@RequestParam("genre")  String genre){
		return bookService.searchByGenre(genre);
	}
	@PreAuthorize("hasAnyAuthority('User','Admin')") //multiple roles
	@GetMapping("/search/book")
	public List<Book> searchByBook(@RequestParam("book")  String book){
		return bookService.searchByBookName(book);
	}
	@PreAuthorize("hasAnyAuthority('User','Admin')") //multiple roles
	@GetMapping("/search2/genre")
	public List<Book> searchByGenre2(@RequestParam("genre")  Genre genre){
		return bookService.searchByGenre2(genre);
	}
	
	@GetMapping
	public List<Book> searchAllbooks(){
		System.out.println("**ALL BOOKS CALLING SERVICE***");
		return bookService.allBooks();
	}
	@GetMapping("/{bid}")
	public Book searchById( @PathVariable("bid") int id) {
		return bookService.searchById(id);
	}
	@PutMapping
	@PreAuthorize("hasAuthority('Admin')") //single role
	public Book updateBook( @RequestBody BookDto bookDto,Principal p) {
		System.out.println(p.getName());
		return bookService.updateBook(bookDto, bookDto.getBookId());
	}
}

