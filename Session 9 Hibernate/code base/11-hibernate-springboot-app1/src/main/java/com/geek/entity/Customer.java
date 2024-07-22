package com.geek.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
private int cid;
private String custName;
@Embedded
private Address address;


public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}


}
