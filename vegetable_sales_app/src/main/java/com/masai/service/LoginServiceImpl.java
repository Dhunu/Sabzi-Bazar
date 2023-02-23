package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.Admin;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Role;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public String loginIntoAccount(User user) throws LoginException {
		
	 if(user.getRole()==Role.ADMIN)
	 {
		
			Admin existingAdmin= adminDao.findByEmail(user.getEmailId());
			
			if(existingAdmin==null)
			{
				throw new LoginException("Please Enter a valid email id");
			}
			else
			{
				Optional<CurrentUserSession> op=sessionDao.findById(existingAdmin.getAdminId());
				
				if(op.isPresent())
				{
					throw new LoginException("you are already Logged In");
				}
				
				
					if(existingAdmin.getPassword()==user.getPassword())
					{
						CurrentUserSession current=new CurrentUserSession();
						
						current.setLocalDateTime(LocalDateTime.now());
						
						String key=RandomString.make(6);
						
						current.setUuid(key);
						current.setUserId(existingAdmin.getAdminId());
						
						sessionDao.save(current);
						
						return current.toString();
						
					}
					
					
						throw new LoginException("Please enter a valid password");
				
				}
				
				
				
			
	 }
	 else if(user.getRole()==Role.CUSTOMER)
	 {
		 
		Customer existingCustomer= customerDao.findByEmail(user.getEmailId());
		
		if(existingCustomer==null)
		{
			throw new LoginException("Please Enter a valid email id");
		}
		else
		{
			Optional<CurrentUserSession> op=sessionDao.findById(existingCustomer.getCustomerId());
			
			if(op.isPresent())
			{
				throw new LoginException("you are already Logged In");
			}
			
			
			
				if(existingCustomer.getPassword()==user.getPassword())
				{
					CurrentUserSession current=new CurrentUserSession();
					
					
					
					String key=RandomString.make(6);
					
					current.setLocalDateTime(LocalDateTime.now());
					current.setUuid(key);
					current.setUserId(existingCustomer.getCustomerId());
					
					sessionDao.save(current);
					
					return current.toString();
					
				}
				
					throw new LoginException("Please enter a valid password");
				
			}
			
			
			
		 
		 
	 }
	 
	 
	
		 throw new LoginException("Please give the valid type");
	 
		
		
		
		
		
		
	}

	@Override
	public String logoutFromAccount(String key) throws LoginException {
		
		CurrentUserSession current=sessionDao.findByUuid(key);
		
		if(current==null)
		{
			throw new LoginException("No user is loggedIn with this key");
		}
		
		sessionDao.delete(current);
		
		
		return"Logged Out!";
		
		
		
	}

}
