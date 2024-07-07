package com.geek.bean.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.geek.bean.AccountRep;
import com.geek.bean.AccountService;
@Component//replaces <bean>
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRep accountRep;
	
	public String creditService(float amt) {
		return accountRep.creditRep(amt);
	}
}
