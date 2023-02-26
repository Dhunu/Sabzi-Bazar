package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.OrderException;
import com.masai.model.Cart;
import com.masai.model.CurrentAdminUserSession;
import com.masai.model.CurrentCustomerUserSession;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.VegetableDTO;
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
		
		Cart cart = new Cart();
		
		if(cart.getVegetableDto().isEmpty()) {
			throw new OrderException("Please first add vegetable into the cart");
		}
		
		List<VegetableDTO> vegetableDTOs = cart.getVegetableDto();
		
		order.setVegetableList(vegetableDTOs);
		
		int totalamount = 0;
		
		for(VegetableDTO dto : vegetableDTOs) {
			
			totalamount += dto.getPrice();
			
		}
		
		order.setTotalAmount(totalamount);
		
		order.setStatus("Processing");
		
		return ordersDao.save(order);
		
	}

	@Override
	public Orders viewOrder(Integer orderId, String key) throws OrderException {
		CurrentCustomerUserSession userSession = customerSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first");
		}
		
		Optional<Orders> opt = ordersDao.findById(orderId);
		
		return opt.get() ;
	}

	@Override
	public Orders updateOrderDetails(Orders order, String key) throws OrderException{
		
		CurrentAdminUserSession userSession = adminSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first as Admin");
		}
		
		return ordersDao.save(order);
	}

	@Override
	public List<Orders> viewAllOrdersByCustomerId(Integer customerId, String key) throws OrderException {
		
		CurrentAdminUserSession userSession = adminSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first as Admin");
		}
		
		List<Orders> list = ordersDao.viewAllOrderByCustomerid(customerId); 
		
		return list;
	}

	@Override
	public List<Orders> viewAllOrdersByDate(LocalDate date, String key) throws OrderException {
		
//		CurrentAdminUserSession userSession = adminSessionDao.findByUuid(key);
//		
//		if(userSession == null) {
//			throw new OrderException("Please login first as Admin");
//		}
//		
//		List<Orders> list = ordersDao.viewAllOrderByDate(date); 
		
		return null;
	}

	@Override
	public List<Orders> viewOrderList(String key) throws OrderException {
		
		CurrentAdminUserSession userSession = adminSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first as Admin");
		}
		
		List<Orders> list = ordersDao.findAll();
		
		return list;
	}

	@Override
	public Orders cancelOrder(Integer orderId, String key) throws OrderException {
		
		CurrentCustomerUserSession userSession = customerSessionDao.findByUuid(key);
		
		if(userSession == null) {
			throw new OrderException("Please login first");
		}
		
		Optional<Orders> opt = ordersDao.findById(orderId);
		
		if(!opt.isPresent()) {
			throw new OrderException("Order not found");
		}
		
		Orders order = opt.get();
		
		order.setStatus("Cancel");
		
		return order;
		
	}

}
