package com.geek.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="EMP")//optional
@Entity //mandatory
public class Employee {
	@Id //mandtory
private int empId;
	@Column(name="ENAME",length = 30)//optional
private String empName;
private String email;

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
