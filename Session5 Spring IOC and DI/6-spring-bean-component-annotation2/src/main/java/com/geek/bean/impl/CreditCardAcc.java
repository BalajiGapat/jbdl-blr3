package com.geek.bean.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.geek.bean.AccountRep;
@Component
@Primary
public class CreditCardAcc implements AccountRep{

	public String creditRep(float amt) {
		return "The amt of "+amt+" credited in ur credit card acc";
	}

}
