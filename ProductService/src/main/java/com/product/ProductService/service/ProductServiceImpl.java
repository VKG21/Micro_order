package com.product.ProductService.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ProductService.dto.ProductDTO;
import com.product.ProductService.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		productDTO.setProductId(UUID.randomUUID().toString());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		productDTO.setProductCrDate(formatter.format(date));
		return productRepository.save(productDTO);
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductDTO> getProductByOrderId(String productId) {
		return productRepository.findByproductId(productId);
	}
}
