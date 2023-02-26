package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.OrderException;
import com.masai.model.Orders;
import com.masai.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrderhandler(@RequestBody Orders orders, @RequestParam String key) throws OrderException{
		
		Orders order = orderService.addOrder(orders, key);
		
		return new ResponseEntity<>(order,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/orders/order/{orderId}")
	public ResponseEntity<Orders> viewOrderhandler(@PathVariable("orderId") Integer orderId, @RequestParam String key) throws OrderException{
		
		Orders order = orderService.viewOrder(orderId, key);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
		
	}
	
	@PutMapping("/orders/update")
	public ResponseEntity<Orders> updateOrderhandler(@RequestBody Orders orders, @RequestParam String key) throws OrderException{
		
		Orders order = orderService.updateOrderDetails(orders, key);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
		
	}
	
	@GetMapping("/orders/viewOrders/{customerId}")
	public ResponseEntity<List<Orders>> viewOrdersByCustomerIdhandler(@PathVariable("customerId") Integer customerId,@RequestParam String key) throws OrderException{
		
		List<Orders> orders = orderService.viewAllOrdersByCustomerId(customerId, key);
		
		return new ResponseEntity<>(orders,HttpStatus.OK);
		
	}
	
	@GetMapping("/orders/viewOrders")
	public ResponseEntity<List<Orders>> viewAllOrdershandler(@RequestParam String key) throws OrderException{
		
		List<Orders> orders = orderService.viewOrderList(key);
		
		return new ResponseEntity<>(orders,HttpStatus.OK);
		
	}
	
	@PutMapping("/orders/cancel/{orderId}")
	public ResponseEntity<Orders> cancelOrderhandler(@PathVariable("orderId") Integer orderId , @RequestParam String key) throws OrderException{
		
		Orders order = orderService.cancelOrder(orderId, key);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
		
	}
	
}
