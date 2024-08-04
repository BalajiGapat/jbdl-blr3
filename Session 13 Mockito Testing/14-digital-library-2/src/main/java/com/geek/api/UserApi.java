package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.geek.entity.Transaction;
import com.geek.entity.User;
import com.geek.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApi {
	@Autowired
	private UserService userService;
	@PostMapping
public User newUser(@RequestBody User user ) {
	return userService.addNewUser(user);
}
	@PostMapping("/borrowBook")
	public Book borrowBookApi(@RequestBody BorrowBookDto bookdto) {
		return userService.borrowBook(bookdto.getBookId(), bookdto.getUserId());
	}
	@GetMapping("/transaction")
	public List<Transaction>  checkUserTransaction(@RequestParam("uid") int userId){
		return userService.chkTransactionByUser(userId);
	}
	
	@PutMapping("/returnBook/{tid}")
	public Book returnBookApi(@PathVariable int tid) {
		return userService.returnBook(tid);
	}
}
