package com.geek.dao;

import com.geek.entity.User;

public interface UserDao {
User registerNewUser(User user);
User searchByUserName(String userName);
}
