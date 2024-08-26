package com.geek.service;

import java.util.List;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Genre;

public interface BookService {
Authour addAuthour(Authour authour);
Book addBook(BookDto book);
Book searchById(int id);
List<Book> searchByGenre2(Genre genre);

List<Book> allBooks();
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(String genre);
Book updateBook(BookDto bookDto,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);
}
