package com.geek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dao.UserDao;
import com.geek.entity.User;

@RestController
public class MyController {
	@Autowired
	private com.geek.dao.UserDao userDao;
	
	@GetMapping
public String test() {
	return "TEST";
}@GetMapping("/user")
public String user() {
	return "USER";
}
	
	@GetMapping("/admin")
	public String admin() {
		return "ADMIN";
	}
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userDao.registerNewUser(user);
	}
	
	@GetMapping("/admin2")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin2() {
		return "ADMIN2";
	}
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/user2")
	public String user2() {
		return "USER2";
	}
}
