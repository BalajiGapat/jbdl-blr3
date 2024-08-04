package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
private int userId;
private String userName;
private String email;
private int phoneNumber;
private String address;

}
