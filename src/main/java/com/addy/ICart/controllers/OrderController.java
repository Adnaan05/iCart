package com.addy.ICart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addy.ICart.Entities.Order;
import com.addy.ICart.Services.OrderService;
import com.addy.ICart.dto.CreateOrderRequest;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
		
		Order order = new Order();
		order = orderService.createOrder(createOrderRequest);
		return ResponseEntity.ok().body(order);
		
		
	}
	
	@GetMapping("/{orderNo}")
	public ResponseEntity<?> getOrder(@PathVariable String orderNo){
		
		Order order = orderService.getOrderByOrderNo(orderNo);
		return ResponseEntity.ok().body(order);
		
		
		
	}

}
