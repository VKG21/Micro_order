package com.order.OrderService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oder")
public class OrderDTO {

	@Id
	private String orderId;
	private String productId;
	private String orderCrDate;
	private long userId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderCrDate() {
		return orderCrDate;
	}
	public void setOrderCrDate(String orderCrDate) {
		this.orderCrDate = orderCrDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", productId=" + productId + ", orderCrDate=" + orderCrDate
				+ ", userId=" + userId + "]";
	}

	
}
