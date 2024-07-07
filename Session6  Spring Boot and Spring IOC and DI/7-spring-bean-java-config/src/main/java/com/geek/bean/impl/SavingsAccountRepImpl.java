package com.geek.bean.impl;

import org.springframework.stereotype.Component;

import com.geek.bean.AccountRep;
@Component
public class SavingsAccountRepImpl implements AccountRep{
	public SavingsAccountRepImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("SavingsAcc constructor ....");
	}
	public String creditRep(float amt) {
		return "Hi the salary of amt "+amt+" credited in ur account";
	}
}
