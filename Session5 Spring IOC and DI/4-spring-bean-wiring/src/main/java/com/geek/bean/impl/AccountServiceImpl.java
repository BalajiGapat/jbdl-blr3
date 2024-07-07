package com.geek.bean.impl;
import org.springframework.beans.factory.annotation.Autowired;

import com.geek.bean.AccountRep;
import com.geek.bean.AccountService;
public class AccountServiceImpl implements AccountService{
	private AccountRep accountRep;
	public AccountServiceImpl() {
		System.out.println("Acc service constructor");
	}
	@Autowired
	public AccountServiceImpl(AccountRep accountRep) {
		System.out.println("Acc service parameterized constructor ");
		this.accountRep=accountRep;
	}
	
	public void setAccountRep(AccountRep accountRep) {
		System.out.println("Acc service setter");
		this.accountRep=accountRep;
	}
	public String creditService(float amt) {
		return accountRep.creditRep(amt);
	}
}
