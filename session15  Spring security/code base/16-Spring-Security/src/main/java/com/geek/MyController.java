package com.geek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/")
public String test() {
	return "Hello";
}
	
	@GetMapping("/home/admin")
	public String admin() {
		return "ADMIN PAGE";
	}
	
	@GetMapping("/home/users")
	public String users() {
		return "USER PAGE";
	}
}
