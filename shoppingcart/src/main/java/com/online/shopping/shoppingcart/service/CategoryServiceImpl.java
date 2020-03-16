package com.online.shopping.shoppingcart.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.online.shopping.shoppingcart.dto.CategoryInfo;
import com.online.shopping.shoppingcart.model.Category;
import com.online.shopping.shoppingcart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository  categoryRepository;
	
	@Override
	public String createCategory(CategoryInfo categoryInfo) {

		Category category=new Category();
		category.setCategoryName(categoryInfo.getCategoryName());
		Category savedCategory = categoryRepository.save(category);
		String success=null;
		if(!ObjectUtils.isEmpty(savedCategory)) {
			success="category created successfully";
		} else {
			throw new RuntimeErrorException(null, "error while saving category");
		}
		return success;
	}
	

}
