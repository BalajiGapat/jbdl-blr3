package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.dto.MailDto;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;
import com.example.entity.User;
import com.example.repo.TransactionRepository;
import com.example.repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionServiceImpl  implements TransactionService{
	@Autowired
  private TransactionRepository transRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void transferFunds(int from, int to, float amt) {
		User user1=userRepo.findById(from).orElseThrow(()-> new RuntimeException("User not found"));
		User user2=userRepo.findById(to).orElseThrow(()-> new RuntimeException("User not found"));
		user1.setAmt(user1.getAmt()-amt);
		user2.setAmt(user2.getAmt()+amt);
		Transaction t1= new Transaction();
		t1.setUserId(from);
		t1.setAnotherId(to);
		t1.setTransactionType(TransactionType.DEBIT);
		t1.setAmt(amt);
		
		Transaction t2= new Transaction();
		t2.setUserId(to);
		t2.setAnotherId(from);
		t2.setTransactionType(TransactionType.CREDIT);
		t2.setAmt(amt);
		transRepo.save(t1);
		transRepo.save(t2);
		MailDto m1= new MailDto();
		m1.setId(user1.getId());
		m1.setMailId(user1.getEmail());
		m1.setAmt(user1.getAmt());
		m1.setTransactionType("DEBIT");
		
		MailDto m2= new MailDto();
		m2.setId(user2.getId());
		m2.setMailId(user2.getEmail());
		m2.setAmt(user2.getAmt());
		m2.setTransactionType("CREDIT");
		
		//sendMail(m1,user1.getUserName());
		//sendMail(m2,user2.getUserName());
		
	}
	private void sendMail(  MailDto mail,String username) {
		try {
			//converting java obj to json text
			String jsonTxt=objectMapper.writeValueAsString(mail);
			kafkaTemplate.send("TRANSACTION",username,jsonTxt);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User searchByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName).orElseThrow(()->new RuntimeException("Invalid user"));
	}

}
