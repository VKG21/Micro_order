package com.order.OrderService.controller.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.OrderService.dto.OrderDTO;
import com.order.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDTO orderProduct(OrderDTO orderDTO) {
		orderDTO.setOrderId(UUID.randomUUID().toString());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		orderDTO.setOrderCrDate(formatter.format(date));
		return orderRepository.save(orderDTO);
	}

	@Override
	public List<OrderDTO> getOrderByUser(long userId) {
		return orderRepository.findByuserId(userId);
	}

}
