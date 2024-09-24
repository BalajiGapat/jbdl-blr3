package com.example.dto;

import com.example.entity.Transaction;
import com.example.entity.TransactionType;

public class MailDto {
private String mailId;
private int id;
private String userName;
private String transactionType;
private float amt;


public float getAmt() {
	return amt;
}
public void setAmt(float amt) {
	this.amt = amt;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}

}
