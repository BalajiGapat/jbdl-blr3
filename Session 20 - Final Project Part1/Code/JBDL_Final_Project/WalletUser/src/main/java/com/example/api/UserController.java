package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserSerivice;

@RestController
public class UserController {
	@Autowired
	private UserSerivice userService;
	@PostMapping("user")
public User addUser( @RequestBody User user) {
	  userService.saveNewUser(user);
	return user;
}
}
