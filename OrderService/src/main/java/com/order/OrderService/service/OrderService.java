package com.order.OrderService.service;

import java.util.List;

import com.order.OrderService.dto.OrderDTO;

public interface OrderService {

	OrderDTO orderProduct(OrderDTO orderDTO);

	List<OrderDTO> getOrderByUser(long userId);

}
