package com.product.ProductService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.ProductService.dto.ProductDTO;

public interface ProductRepository extends JpaRepository<ProductDTO,Long> {

	List<ProductDTO> findByproductId(String productId);

}
