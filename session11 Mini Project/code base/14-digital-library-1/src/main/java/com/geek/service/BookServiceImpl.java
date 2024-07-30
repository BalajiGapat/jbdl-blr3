package com.geek.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.repository.AuthorRepository;
import com.geek.repository.BookRepository;
@Component
public class BookServiceImpl implements BookService {
    @Autowired
	private AuthorRepository authorRepo;
    @Autowired
   private BookRepository bookRepo;
	@Override
	public Authour addAuthour(Authour authour) {
	//	if(authour.getName().equals(""))
		//	throw new RuntimeException("Invalid field");
		authorRepo.save(authour);
		return authour;
	}

	@Override
	public Book addBook(BookDto bookDto) {
		Authour authour=authorRepo.findById(bookDto.getAuthourId()).get();
		Book book=new Book();
		//copying from dto to book entity
		/*book.setBookId(bookDto.getBookId());
		book.setBookName(bookDto.getBookName());
		book.setCost(bookDto.getCost());
		book.setStock(bookDto.getStock());
		book.setGenre(bookDto.getGenre());
		book.setAuthour(authour);*/
		BeanUtils.copyProperties(bookDto, book);
		book.setAuthour(authour);
		bookRepo.save(book);
		return book;
	}

	@Override
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByAuthour(int authourId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchByGenre(String genre) {
		return bookRepo.searchByGenre(genre);
	}

	@Override
	public Book updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepo.findByBookName(bookName);
	}

}
