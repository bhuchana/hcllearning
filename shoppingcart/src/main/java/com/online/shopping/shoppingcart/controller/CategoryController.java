package com.online.shopping.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.shoppingcart.dto.CategoryInfo;
import com.online.shopping.shoppingcart.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryInfo categoryInfo ){
		
		String message = categoryService.createCategory(categoryInfo);
		ResponseEntity<String> responseEntity=new ResponseEntity<String>(message, HttpStatus.CREATED);
		return responseEntity;
	}
}
