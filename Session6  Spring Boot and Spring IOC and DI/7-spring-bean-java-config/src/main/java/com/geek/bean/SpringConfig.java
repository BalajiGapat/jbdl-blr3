package com.geek.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.geek.bean.impl.AccountServiceImpl;
import com.geek.bean.impl.SavingsAccountRepImpl;
@Configuration
@ComponentScan(basePackages = "com.geek.bean")
public class SpringConfig {
	@Bean("service")
 public AccountService getAccService() {
	 return new AccountServiceImpl();
 }
	/*
	 * @Bean public AccountRep getSavingsAcc() { return new SavingsAccountRepImpl();
	 * }
	 */
}
