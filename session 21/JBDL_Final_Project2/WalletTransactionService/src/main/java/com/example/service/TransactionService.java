package com.example.service;

import com.example.entity.User;

public interface TransactionService {
 void transferFunds(int from,int to, float amt);
 User searchByUserName(String userName);
}
