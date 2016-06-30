package com.secondhandshop.springmvc.service;

import java.util.List;

import com.secondhandshop.springmvc.model.InputProduct;
import com.secondhandshop.springmvc.model.Product;
import com.secondhandshop.springmvc.model.Supplier;


public interface ProductService {
	
	Product findById(int id);
	
	void saveProduct(Product ip);
	
	void updateProduct(Product ip);
	
	void deleteProductById(int id);

	List<Product> findAllProducts(); 
	
	List<Product> findProductsByInputProductId(int id);

}