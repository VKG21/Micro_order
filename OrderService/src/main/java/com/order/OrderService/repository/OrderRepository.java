package com.order.OrderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.OrderService.dto.OrderDTO;

public interface OrderRepository extends JpaRepository<OrderDTO,String>{

	List<OrderDTO> findByuserId(long userId);

}
