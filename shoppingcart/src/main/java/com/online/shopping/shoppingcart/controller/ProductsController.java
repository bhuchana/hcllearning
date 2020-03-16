package com.online.shopping.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.shoppingcart.dto.ProductInfo;
import com.online.shopping.shoppingcart.service.ProductService;

@RestController
public class ProductsController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts(){
		
		List<ProductInfo> products = productService.getAllProducts();
		ResponseEntity<?> responseEntity=new ResponseEntity<>(products, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductInfo productInfo ){
		
		String message = productService.createProduct(productInfo);
		ResponseEntity<String> responseEntity=new ResponseEntity<String>(message, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/products/{searchTerm}")
	public ResponseEntity<?> searchProducts(@PathVariable("searchTerm") String searchTerm ){
		
		List<ProductInfo> products = productService.searchProducts(searchTerm);
		ResponseEntity<?> responseEntity=new ResponseEntity<>(products, HttpStatus.OK);
		return responseEntity;
	}
	 

}
