package com.geek.entity;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
@DynamicUpdate
@DynamicInsert//wont insert null values(since defalt is null)
public class Employee {
	@Id
private int empId;
private String empName;
@Enumerated(EnumType.STRING)
private Designation designation;
@ManyToOne
@JoinColumn(name = "deptId")
private Department dept;
@CreationTimestamp
private LocalDateTime created;
@UpdateTimestamp
private LocalDateTime updated;

public Designation getDesignation() {
	return designation;
}
public void setDesignation(Designation designation) {
	this.designation = designation;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}
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

}
