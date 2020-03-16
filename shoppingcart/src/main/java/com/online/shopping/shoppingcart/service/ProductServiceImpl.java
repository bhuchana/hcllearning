package com.online.shopping.shoppingcart.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.online.shopping.shoppingcart.dto.ProductInfo;
import com.online.shopping.shoppingcart.model.Category;
import com.online.shopping.shoppingcart.model.Product;
import com.online.shopping.shoppingcart.repository.CategoryRepository;
import com.online.shopping.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<ProductInfo> getAllProducts() {
		
		List<Product> productList = (List<Product>)productRepository.findAll();
		List<ProductInfo> productInfos=null;
		if(!productList.isEmpty()) {
			productInfos = productList.stream().map(
					product -> new ProductInfo(
							product.getId(),
							product.getName(),
							product.getPrice(),
							product.getCategory().getCategoryName()
							)).
	                     collect(Collectors.toList());	
			}
		
		
		return productInfos;
	}

	@Override
	public String createProduct(ProductInfo productInfo) {
		Product product=new Product();
		product.setName(productInfo.getName());
		product.setPrice(productInfo.getPrice());
		String categoryId = productInfo.getCategoryId();
		Optional<Category> findById = categoryRepository.findById(Long.valueOf(categoryId));
		if(findById.isPresent()) {
			Category category=findById.get();
			product.setCategory(category);
			product.setAddedOn(new Date());
		}
		Product product2 = productRepository.save(product);
		if(ObjectUtils.isEmpty(product2)) {
			throw new RuntimeException("Error while creating product");
		} 
		
		return "product created successfully";
	}

	@Override
	public List<ProductInfo> searchProducts(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

}
