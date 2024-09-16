package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class KafkaConsumer {
	 @Autowired
	 private SimpleMailMessage simpleMailMsg;
	 @Autowired
	 private JavaMailSender javaMailSender;
		@Autowired
		ObjectMapper objectMapper;
	@KafkaListener(topics = AppConstants.NEW_USER,groupId = "group-id")
public void consume(ConsumerRecord<String, String> record ) {
	System.out.println("******u have a notification********");
	System.out.println(record.key());
	System.out.println(record.value());
	String jsonTxt=record.value();
	try {
		User user=objectMapper.readValue(jsonTxt, User.class);
		simpleMailMsg.setTo(user.getEmail());
		simpleMailMsg.setSubject("Succesfully Registered .....");
		simpleMailMsg.setFrom("albinxavier@gmail.com");
		simpleMailMsg.setText("Hi "+user.getUserName()+" Congrats u have created ur wallet account");
		javaMailSender.send(simpleMailMsg);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
