package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

@Service
public interface OrderService {
	
	public Orders addOrder(Orders order);
	
	public Orders viewOrder(Orders order) throws OrderException;
	
	public Orders updateOrderDetails(Orders order) throws OrderException;
	
	public List<Orders> viewAllOrdersByCustomerId(Integer customerId) throws OrderException;;
	
	public List<Orders> viewAllOrdersByDate(LocalDate date) throws OrderException;;
	
	public List<Orders> viewOrderList() throws OrderException;
	
	public Orders cancelOrder(Integer orderId)throws OrderException;
	
}
