package com.secondhandshop.springmvc.dao;

import java.util.List;

import com.secondhandshop.springmvc.model.InputProduct;
import com.secondhandshop.springmvc.model.Product;
import com.secondhandshop.springmvc.model.Supplier;


public interface ProductDao {

	Product findById(int id);
	
	void save(Product product);
	
	void deleteById(int id);
	
	List<Product> findAllProducts();
	
	List<Product> findProductsByInputProductId(int id);

}

