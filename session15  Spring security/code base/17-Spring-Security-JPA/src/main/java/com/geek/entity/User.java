package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user1234")
public class User {
	@Id
private int id;
private String userName;
private String password;
private String roles;
private boolean enabled;


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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roles=" + roles + ", enabled="
			+ enabled + "]";
}



}
