package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.model.CurrentCustomerUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerSessionDao sessionDao;

	@Override
	public Customer getCustomerByEmail(String email) throws CustomerException {
		
		Customer c=customerDao.findByEmail(email);
		
		if(c==null)
		{
			throw new CustomerException("No customer is there with email"+email);
		}
		
		return c;
		
		
	}

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
		Customer c=customerDao.findByEmail(customer.getEmail());
		
		if(c!=null)
		{
			throw new CustomerException("Customer already Exist with this email");
		}
		
		if(customer.getPassword().equals(customer.getConfirmPassword()))
		{
			return customerDao.save(customer);
		}
		else
		{
			throw new CustomerException("Password and Confirm Password did not matched");
		}
		
		
		
		
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c=customerDao.findByEmail(customer.getEmail());
		
		if(c==null)
		{
			throw new CustomerException("Please enter a valid email id");
		}
		
		  CurrentCustomerUserSession cus= sessionDao.findByUuid(key);
		  
		  if(cus==null)
		  {
			  throw new CustomerException("Please login first");
		  }
		  
		  Customer ct=customerDao.save(customer);
		  
		return ct;
	}
	


}
