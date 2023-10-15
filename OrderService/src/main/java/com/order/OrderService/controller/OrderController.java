package com.order.OrderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.OrderService.dto.OrderDTO;
import com.order.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.orderProduct(orderDTO));	
	}
	
	
	@GetMapping("/getOrder/{userId}")
	public ResponseEntity<List<OrderDTO>> createOrder(@PathVariable long userId){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.getOrderByUser(userId));	
	}
}
