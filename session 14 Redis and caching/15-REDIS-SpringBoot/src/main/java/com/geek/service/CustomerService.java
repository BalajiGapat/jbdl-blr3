package com.geek.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.geek.model.Customer;
import com.geek.repo.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;
	//Can create a HashMap cache....
	//sPel
	//@CachePut(key = "cust",value = "#c.cid")
	@CachePut(key = "#c.cid",value = "cust")
public Customer addNewCustomerService(Customer c ) {
	Customer c1=custRepo.save(c);
	//store in the HashMap as well
	return c1;
}
	  @CacheEvict(value = "cust", allEntries = true)
	public List<Customer> allCustomersService() {
		return custRepo.findAll();
	}
//	@Cacheable(key="cust",value="#id")
	  @Cacheable(key="#id",value="cust")
	public Customer searchByIdService(int id) {
		System.out.println("Connecting with DB....");
		//Check is the data available in hashMap
		    //read from Map and return it
		//else
		    //read from DB....
		return custRepo.findById(id).get();
	}
}
