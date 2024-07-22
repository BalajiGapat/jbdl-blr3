package com.geek.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
@Entity
public class Student {
	@Id
private int studId;
private String studName;
@ElementCollection
@JoinTable(name = "STUDENT_ADDRESS_MAP",
joinColumns = @JoinColumn(name="studid"))
private List<StudentAddress> address;
public int getStudId() {
	return studId;
}
public void setStudId(int studId) {
	this.studId = studId;
}
public String getStudName() {
	return studName;
}
public void setStudName(String studName) {
	this.studName = studName;
}
public List<StudentAddress> getAddress() {
	return address;
}
public void setAddress(List<StudentAddress> address) {
	this.address = address;
}


}
