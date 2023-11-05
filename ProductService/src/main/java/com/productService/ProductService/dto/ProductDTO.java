package com.productService.ProductService.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Product")
public class ProductDTO {

	@Id
	private String productId;

	private String productName;

	private String productCrDate;

	private long productTotal;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCrDate() {
		return productCrDate;
	}

	public void setProductCrDate(String productCrDate) {
		this.productCrDate = productCrDate;
	}

	public long getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(long productTotal) {
		this.productTotal = productTotal;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productCrDate="
				+ productCrDate + ", productTotal=" + productTotal + "]";
	}


}