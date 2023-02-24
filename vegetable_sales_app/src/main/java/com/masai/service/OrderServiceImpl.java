package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;

public class OrderServiceImpl implements OrderService{

	@Override
	public Orders addOrder(Orders order) {
		
		
		
		
		return null;
	}

	@Override
	public Orders viewOrder(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders updateOrderDetails(Orders order) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByCustomerId(Integer customerId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByDate(LocalDate date) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewOrderList() throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders cancelOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
