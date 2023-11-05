package com.productService.ProductService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productService.ProductService.dto.ProductDTO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, String> {

	List<ProductDTO> findByproductId(String productId);

}