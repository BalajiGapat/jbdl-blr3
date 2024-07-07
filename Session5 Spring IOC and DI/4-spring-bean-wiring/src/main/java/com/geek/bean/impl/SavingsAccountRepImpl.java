package com.geek.bean.impl;

import com.geek.bean.AccountRep;
public class SavingsAccountRepImpl implements AccountRep{
	public SavingsAccountRepImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("SavingsAcc constructor ....");
	}
	public String creditRep(float amt) {
		return "Hi the salary of amt "+amt+" credited in ur account";
	}
}
