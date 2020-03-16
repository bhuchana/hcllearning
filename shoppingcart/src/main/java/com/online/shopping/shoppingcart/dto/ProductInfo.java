package com.online.shopping.shoppingcart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductInfo {
	
	@JsonIgnore
	private Long productId;
	private String name;
	private Double price;
	private String categoryId;

	public ProductInfo(Long productId, String name, Double price, String categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.setCategoryId(categoryId);
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	

}
