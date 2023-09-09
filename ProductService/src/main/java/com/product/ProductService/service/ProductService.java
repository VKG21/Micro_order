package com.product.ProductService.service;

import java.util.List;

import com.product.ProductService.dto.ProductDTO;

public interface ProductService {

	ProductDTO saveProduct(ProductDTO productDTO);

	List<ProductDTO> getAllProduct();

	List<ProductDTO> getProductByOrderId(String productId);

}
