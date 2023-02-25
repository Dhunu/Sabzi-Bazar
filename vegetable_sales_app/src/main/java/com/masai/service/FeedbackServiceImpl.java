package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.model.Feedback;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.FeedbackDao;
import com.masai.repository.OrdersDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerSessionDao customerSessionDao;

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
