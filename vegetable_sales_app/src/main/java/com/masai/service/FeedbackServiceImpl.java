package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Feedback;
import com.masai.model.Orders;
import com.masai.repository.CustomerDao;
import com.masai.repository.FeedbackDao;
import com.masai.repository.OrdersDao;
import com.masai.repository.SessionDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SessionDao sessionDao;

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Autowired
	private OrdersDao orderDao;

	@Override
	public Feedback addFeedBack(Feedback feedback, String key, Integer orderId)
			throws FeedbackException, CustomerException {
//		CurrentUserSession loggedInUser = sessionDao.findByUuid(key);
//		if(loggedInUser==null) {
//			throw new CustomerException("user not logged in");
//		}
//		Optional<Orders> existingOrder = orderDao.findById(orderId);
//		if(existingOrder.isPresent()==false)
//			throw new CustomerException("Not found");
//		
//		Orders order1 = existingOrder.get();
//		
		
			
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedBack(int vegetableId) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedBack(Integer customerId) throws FeedbackException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
