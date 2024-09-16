package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthRequest;
import com.example.dto.ResponseDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserSerivice;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserSerivice userService;
	@Autowired
	UserRepository userRepo;
	 @Autowired
	    private AuthenticationManager authenticationManager;
	@PostMapping("/register")
public User addUser( @RequestBody User user) {
	  userService.saveNewUser(user);
	return user;
}
	@PostMapping("/login")
    public ResponseDto getToken(@RequestBody AuthRequest authRequest) {
    	System.out.println("yes .."+authRequest.getUsername()+"  "+authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        System.out.println(authenticate.isAuthenticated());
        if (authenticate.isAuthenticated()) {
        	String token=
        			userService.generateToken(authRequest.getUsername());
        	        	User user=
        	userRepo.findByUserName(authRequest.getUsername()).get();
        	ResponseDto resDto=new ResponseDto();
        	resDto.setToken(token);
        	resDto.setRole(user.getRole());
        	return resDto;
        } else {
            throw new RuntimeException("invalid access");
        }
    }
}
