package com.geek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.geek.dto.BookDto;
import com.geek.entity.Authour;
import com.geek.entity.Book;
import com.geek.entity.Transaction;
import com.geek.repository.AuthorRepository;
import com.geek.repository.BookRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
import com.geek.service.BookServiceImpl;
import com.geek.service.UserServiceImpl;

@SpringBootTest
public class BookServiceTest {
    @Mock
	private AuthorRepository authRep;
    @Mock
    private BookRepository bookRep;
    @InjectMocks
    private BookServiceImpl bookService;
    
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
	private PenaltyRepository penaltyRepo;
    @Mock
	private TransactionRepository transRepo;
	@Test
	public void addBookTestSuccess() {
		BookDto dto= new BookDto();
		dto.setBookId(1);
		dto.setBookName("Test Book");
		dto.setCost(100);
		dto.setAuthourId(101);
		
		Authour authour= new Authour();
		authour.setAuthourId(101);
		authour.setName("Test Authour");
		//PRE-CONDITION
		when(authRep.findById(101)).
		thenReturn(Optional.of(authour));
		
		bookService.addBook(dto);
		Book addedBook=new Book();
		addedBook.setAuthour(authour);
		BeanUtils.copyProperties(dto, addedBook);
		when(bookRep.save(any(Book.class))).thenReturn(addedBook);
	    assertEquals(addedBook.getAuthour().getName(), "Test Authour");

	    //to verify the service whether it called repository or not ....
	    verify(authRep,times(1)).findById(101);
	    verify(bookRep,times(1)).save(any(Book.class));
	}
	
	@Test
	public void addBookTestFailure() {
		BookDto dto= new BookDto();
		dto.setBookId(1);
		dto.setBookName("Test Book");
		dto.setCost(100);
		dto.setAuthourId(101);
		//PRE-CONDITION
		when(authRep.findById(1)).thenReturn(Optional.empty());
		//bookService.addBook(dto);
		Exception e=
		assertThrows(RuntimeException.class, ()->bookService.addBook(dto));
		assertEquals("Invalid Authour id", e.getMessage());
	    verify(bookRep,times(0)).save(any(Book.class));
	}
	@Test
	public void testBookReturnWithPenality() {
		int transactionId=1;
		Transaction t= new Transaction();
		t.setTransactionId(1);
		t.setBorrowDate(LocalDate.now().minusDays(13));
		Book book=new Book();
		book.setBookName("TestBook");
		t.setBook(book);
		
		when(transRepo.findById(1)).thenReturn(Optional.of(t));
		Book returnedBook=
		userService.returnBook(1);
		assertEquals(book.getBookName(), returnedBook.getBookName());
		
		verify(transRepo,times(1)).save(any(Transaction.class));
		System.out.println(t.getPenalty());
		assertEquals(150, t.getPenalty().getAmount());
	}
}
