package com.geek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

}
