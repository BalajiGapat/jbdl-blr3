package com.geek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.exception.ApplicationException;
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
	@Cacheable(value = "book",key = "#bookDto.bookId")
	public Book addBook(BookDto bookDto) {
		Authour authour=null;
		//optional -> to avoid NullPointerException
				Optional<Authour>optional=
	authorRepo.findById(bookDto.getAuthourId());
				
	//authorRepo.findById(bookDto.getAuthourId()).orElseThrow(()-> new RuntimeException("Invalid Authour id"));
	//	Authour authour=optional.
			//	orElseThrow(()-> new RuntimeException("Invalid Authour id"));
		if(optional.isEmpty())
			throw new   RuntimeException("Invalid Authour id");
		else
			 authour=optional.get();
		
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
		bookRepo.save(book); //new book
		return book;
	}

	@Override
	@Cacheable(value = "books")
	public List<Book> allBooks() {
		System.out.println("**GETTING ALL BOOKS FROM THE DB**");
		return bookRepo.findAll();
	}

	@Override
	public List<Book> searchByAuthour(int authourId) {
		// TODO Auto-generated method stub
		//implement it 
		return null;
	}

	@Override
	public List<Book> searchByGenre(String genre) {
		return bookRepo.searchByGenre(genre);
	}

	@Override
	public Book updateBook(BookDto book, int bookId) {
		Book b=
		bookRepo.findById(bookId).orElseThrow(()->new ApplicationException("Book not found"));
		Authour a=
		authorRepo.findById(book.getAuthourId()).orElseThrow(()->new ApplicationException("Authour not found"));
		BeanUtils.copyProperties(book, b);
		b.setAuthour(a);
		bookRepo.save(b);
		return b;
	}

	@Override
	public void removeBook(int bookId) {
		bookRepo.deleteById(bookId);
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepo.findByBookName(bookName);
	}
	@Override
	public List<Book> searchByGenre2(Genre genre) {
		return bookRepo.searchByGenreByJqpl(genre);
	}

	@Override
	@Cacheable(value = "book",key = "#id")
	public Book searchById(int id) {
		//bookRepo.findById(id).orElseThrow(()->new RuntimeException("Book id not found"));
	Optional<Book> optionalBook= bookRepo.findById(id);
	if(optionalBook.isPresent())
		return optionalBook.get();
	else
		 throw new ApplicationException("Book id "+id+"  not found");
	}
}
