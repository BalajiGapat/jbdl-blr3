package com.geek.service;

import java.util.List;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;

public interface BookService {
Authour addAuthour(Authour authour);
Book addBook(BookDto book);
List<Book> allBooks();
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(String genre);
Book updateBook(Book book,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);
}
