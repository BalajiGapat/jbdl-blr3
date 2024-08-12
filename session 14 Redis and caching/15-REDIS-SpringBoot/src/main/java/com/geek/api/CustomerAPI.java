package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.model.Customer;
import com.geek.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	@Autowired
	
	private CustomerService service;
 @PostMapping
	public Customer addNewCustomer(@RequestBody Customer c) {
		return service.addNewCustomerService(c);
	}
 @GetMapping
	public List<Customer> allCustomers() {
		return service.allCustomersService();
	}
 @GetMapping("/{id}")
	public Customer searchById(@PathVariable int id) {
		return service.searchByIdService(id);
	}
}
