package com.geek.bean.impl;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.geek.bean.AccountRep;
import com.geek.bean.AccountService;
@Component//replaces <bean>
public class AccountServiceImpl implements AccountService{
	public AccountServiceImpl() {
		System.out.println("constructor service");
	}
	//@Autowired
	//@Qualifier("savings")
	private AccountRep accountRep;
	@Autowired
	@Qualifier("savings")
	public void setAccountRep(AccountRep accountRep) {
		this.accountRep = accountRep;
		System.out.println("setter...");
	}
   @PostConstruct
	public void init() {
		System.out.println("****some initialization task***");
	}
   @PreDestroy
    public void destroy() {
    	System.out.println("**pre destroy**");
    }

	public String creditService(float amt) {
		return accountRep.creditRep(amt);
	}
}
