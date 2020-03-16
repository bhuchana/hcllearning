package com.online.shopping.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.shoppingcart.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	//findByNameContainingAnd
	

}
