package com.online.shopping.shoppingcart.service;

import java.util.List;

import com.online.shopping.shoppingcart.dto.ProductInfo;

public interface ProductService {
	
	List<ProductInfo> getAllProducts();

	String createProduct(ProductInfo productInfo);

	List<ProductInfo> searchProducts(String searchTerm);

}
