package com.geek.api;

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

import com.geek.dto.BorrowBookDto;
import com.geek.entity.Book;
import com.geek.entity.BookUser;
import com.geek.entity.Transaction;
import com.geek.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@PostMapping
	@PreAuthorize("hasAnyAuthority('Admin','User')") //single role
public BookUser newUser(@RequestBody BookUser user ) {
	return userService.addNewUser(user);
}
	@PreAuthorize("hasAuthority('User')") //single role
	@PostMapping("/borrowBook")
	public Book borrowBookApi(@RequestBody BorrowBookDto bookdto) {
		return userService.borrowBook(bookdto.getBookId(), bookdto.getUserId());
	}
	@PreAuthorize("hasAnyAuthority('Admin','User')") //multiple role
	@GetMapping("/transaction")
	public List<Transaction>  checkUserTransaction(@RequestParam("uid") int userId){
		return userService.chkTransactionByUser(userId);
	}
	@PreAuthorize("hasAuthority('Admin')") //single role
	@PutMapping("/returnBook/{tid}")
	public Book returnBookApi(@PathVariable int tid) {
		return userService.returnBook(tid);
	}
}
