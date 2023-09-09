package com.product.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProductService.dto.ProductDTO;
import com.product.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/save")
	private ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productDTO));
		
	}
	
	@GetMapping("/getAll")
	private ResponseEntity<List<ProductDTO>> GetProduct(){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.getAllProduct());
		
	}
	
	
	@GetMapping("/get/{productId}")
	private ResponseEntity<List<ProductDTO>> getProductByOrderId(@PathVariable String productId ){
		System.out.println("-------------------");
		System.out.println("--------------------productId"+""+productId);
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.getProductByOrderId(productId));
		
	}
	

}
