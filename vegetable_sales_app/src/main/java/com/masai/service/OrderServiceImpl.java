package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrderException;
import com.masai.model.CurrentAdminUserSession;
import com.masai.model.CurrentCustomerUserSession;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.AdminSessionDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;
import com.masai.repository.OrdersDao;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private CustomerSessionDao customerSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Orders addOrder(Orders order, String key) throws  OrderException{
		CurrentCustomerUserSession userSession = customerSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first");
		}
		
		Optional<Customer> opt = customerDao.findById(userSession.getUserId()) ;
		
		Customer customer = opt.get();
		
		customer.getOrders().add(order);
		
		order.setCustomer(customer);
		
		return ordersDao.save(order);
		
	}

	@Override
	public Orders viewOrder(Orders order, String key) throws OrderException {
		CurrentCustomerUserSession userSession = customerSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first");
		}
		
		
		return null;
	}

	@Override
	public Orders updateOrderDetails(Orders order, String key) throws OrderException{
		
		CurrentCustomerUserSession userSession = customerSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first");
		}
		
		return ordersDao.save(order);
	}

	@Override
	public List<Orders> viewAllOrdersByCustomerId(Integer customerId, String key) throws OrderException {
		
		CurrentAdminUserSession userSession = adminSessionDao.findByUuid(key);
		
		
		
		
		return null;
	}

	@Override
	public List<Orders> viewAllOrdersByDate(LocalDate date, String key) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewOrderList(String key) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders cancelOrder(Integer orderId, String key) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
