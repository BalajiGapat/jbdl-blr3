package com.geek.threads;

public class SingleTonDemo1 {
public static void main(String[] args) {
	/*new BankingService();
	new BankingService();
	new BankingService();
	new BankingService();
	*/
	BankingService service=
			BankingService.getBankingService();
	BankingService service2=
			BankingService.getBankingService();	
	BankingService service3=
			BankingService.getBankingService();	
}
}
