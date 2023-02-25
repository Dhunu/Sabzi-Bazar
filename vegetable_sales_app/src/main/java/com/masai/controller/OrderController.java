package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
}
