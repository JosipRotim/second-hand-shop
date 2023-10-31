package com.cardealership.springmvc.repositories;

import java.util.List;

import com.cardealership.springmvc.model.Product;


public interface ProductDao {

	Product findById(int id);
	
	void save(Product product);
	
	void deleteById(int id);
	
	List<Product> findAllProducts();
	
	List<Product> findProductsByInputProductId(int id);

}

