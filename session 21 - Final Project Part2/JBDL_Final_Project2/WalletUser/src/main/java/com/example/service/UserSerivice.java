package com.example.service;
import com.example.entity.User;
public interface UserSerivice {
 User saveNewUser(User user);
 void sendNotification(String userName, User user);
String generateToken(String username);
void validateToken(String token);
}
