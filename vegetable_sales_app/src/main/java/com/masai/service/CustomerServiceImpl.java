package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;

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
			throw new CustomerException("Customer already Exist");
		}
		
		return customerDao.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c=customerDao.findByEmail(customer.getEmail());
		
		if(c==null)
		{
			throw new CustomerException("Please enter a valid email id");
		}
		
		  CurrentUserSession cus= sessionDao.findByUuid(key);
		  
		  if(cus==null)
		  {
			  throw new CustomerException("Please login first");
		  }
		  
		  Customer ct=customerDao.save(customer);
		  
		return ct;
	}
	


}
