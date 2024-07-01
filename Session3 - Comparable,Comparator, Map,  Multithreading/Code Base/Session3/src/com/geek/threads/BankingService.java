package com.geek.threads;

public class BankingService {
private BankingService() {
	 System.out.println("BankingService created...");
}
private static BankingService bankingService=null;

//can be accessed directly by the class name
public static BankingService getBankingService() {
	if(bankingService==null) { //to avoid getting locked(to improve performance)
	synchronized(BankingService.class) {
			if(bankingService==null)
			   bankingService= new BankingService();
			}
	}
	return bankingService;
}
}
