package com.geek.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Department {
	@Id
private int deptId;
private String deptName;
//Default fetch type is LAZY for one to many 
@OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)
//@JoinColumn(name = "deptId")
private List<Employee> empList;
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public List<Employee> getEmpList() {
	return empList;
}
public void setEmpList(List<Employee> empList) {
	this.empList = empList;
}


}
