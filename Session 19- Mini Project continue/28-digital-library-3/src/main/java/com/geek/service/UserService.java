package com.geek.service;

import java.util.List;

import com.geek.entity.Book;
import com.geek.entity.BookUser;
import com.geek.entity.Transaction;

public interface UserService {
	BookUser addNewUser(BookUser u);
	Book borrowBook(int bookId,int userId);
	Book returnBook(int tid);
	boolean checkAvailability(int bookId);
	List<Transaction>  chkTransactionByUser(int userId);
}
