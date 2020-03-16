package com.online.shopping.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.shoppingcart.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
