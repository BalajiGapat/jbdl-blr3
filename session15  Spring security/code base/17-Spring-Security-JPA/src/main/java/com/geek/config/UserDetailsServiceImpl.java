package com.geek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.geek.dao.UserDao;
import com.geek.entity.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.searchByUserName(username);
		System.out.println(user);
		return new MyUserDetails(user);
	}

}
