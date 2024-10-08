package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TransactionDto;
import com.example.entity.User;
import com.example.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@PostMapping("/transfer")
public TransactionDto transferFunds(@RequestHeader("loggedInUser") String user, @RequestBody TransactionDto dto) {
		User u=transactionService.searchByUserName(user);
		transactionService.transferFunds(u.getId(), dto.getTo(), dto.getAmt());
		
	return dto;
}
	@GetMapping("transaction/test")
	public String test( @RequestHeader("loggedInUser") String user ) {
		return "Transaction test "+user;
	}
}
