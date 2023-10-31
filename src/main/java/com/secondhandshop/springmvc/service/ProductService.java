package com.cardealership.springmvc.service;

import java.util.List;

import com.cardealership.springmvc.model.InputProduct;
import com.cardealership.springmvc.model.Product;
import com.cardealership.springmvc.model.Supplier;


public interface ProductService {
	
	Product findById(int id);
	
	void saveProduct(Product ip);
	
	void updateProduct(Product ip);
	
	void deleteProductById(int id);

	List<Product> findAllProducts(); 
	
	List<Product> findProductsByInputProductId(int id);

}