package com.geek.service;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.geek.entity.Book;
import com.geek.entity.Penalty;
import com.geek.entity.Transaction;
import com.geek.entity.BookUser;
import com.geek.repository.BookRepository;
import com.geek.repository.BookUserRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private BookUserRepository userRepo;
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	private PenaltyRepository penaltyRepo;
	@Override
	public BookUser addNewUser(BookUser u) {
		return userRepo.save(u);
	}
	@Override
	@Transactional//(propagation = Propagation.)
	public Book borrowBook(int bookId,int userId) {
		System.out.println(Thread.currentThread());
		if(checkAvailability(bookId)) {
		Book b=bookRepo.findById(bookId).
				orElseThrow(()-> new RuntimeException("Book Not Found"));
		BookUser user=userRepo.findById(userId)
				.orElseThrow(()-> new RuntimeException("User not found"));
		Transaction t= new Transaction();
		t.setBorrowDate(LocalDate.now());
		t.setBook(b);
		t.setUser(user);
		b.setStock(b.getStock()-1);
		transRepo.save(t);
		bookRepo.save(b);
		return b;
		}
		else 
			return null;
	}

	@Override
	public Book returnBook(int tid) {
		Transaction t=
		transRepo.findById(tid).orElseThrow(()->new RuntimeException("Invalid transaction id"));
		LocalDate borrowDate=t.getBorrowDate();
		LocalDateTime l1=borrowDate.atStartOfDay();
		LocalDateTime curDate=LocalDateTime.now();
	    Duration duration=Duration.between(l1, curDate);
	    long dateDiff= duration.toDays();
	    System.out.println(dateDiff);
	    if(dateDiff>10) {
	    	Penalty penalty= new Penalty();
	    	int amt=(int) ((dateDiff-10)*50);
	    	penalty.setAmount(amt);
	    	penalty.setNoOfDays((int)dateDiff);
	    	penalty.setRemarks("Fine");
	    	penaltyRepo.save(penalty);
	    	t.setPenalty(penalty);
	    }
	    t.setReturnedDate(LocalDate.now());
	    transRepo.save(t);
	    Book b=t.getBook();
	    b.setStock(b.getStock()+1);
	    bookRepo.save(b);
		return b;
	}

	@Override
	public boolean checkAvailability(int bookId) {
		Book b=bookRepo.findById(bookId).
				orElseThrow(()-> new RuntimeException("Book Not Found"));
		if(b.getStock()>0)
			return true;
		return false;
	}
	@Override
	public List<Transaction> chkTransactionByUser(int userId) {
		return transRepo.searchTransactionByUser(userId);
	}

}
