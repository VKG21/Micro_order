package com.productService.ProductService.service;

import java.util.List;


import com.productService.ProductService.dto.ProductDTO;

import java.util.List;



public interface ProductService {

	ProductDTO saveProduct(ProductDTO productDTO);

	List<ProductDTO> getAllProduct();

	List<ProductDTO> getProductByOrderId(String productId);

}
