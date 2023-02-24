package com.masai.service;

import java.util.List;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.FeedbackException;
import com.masai.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedBack(Feedback feedback, String key, Integer orderId) throws FeedbackException, CustomerException;
	
	public List<Feedback> viewAllFeedBack(int vegetableId)throws FeedbackException;
	
	public Feedback viewFeedBack(Integer customerId) throws FeedbackException,CustomerException;
}
