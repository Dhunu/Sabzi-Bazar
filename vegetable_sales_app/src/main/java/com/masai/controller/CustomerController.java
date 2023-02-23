package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer c=customerService.createCustomer(customer);
	
		return new ResponseEntity<>(c,HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer,@RequestParam String key) throws CustomerException{
		
		Customer c=customerService.updateCustomer(customer, key);
	
		return new ResponseEntity<>(c,HttpStatus.OK);
		
		
	}
	
	
	

}
