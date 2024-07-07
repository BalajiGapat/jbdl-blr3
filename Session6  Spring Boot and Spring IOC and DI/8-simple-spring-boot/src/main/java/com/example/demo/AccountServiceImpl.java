package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl  implements AccountService{
public AccountServiceImpl() {
 System.out.println("Constructor....");
}
@Override
	public void credit() {
		
	}
}

interface AccountService {
	void credit();
}