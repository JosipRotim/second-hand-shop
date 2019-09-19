package com.secondhandshop.springmvc.repositories;

import java.util.List;

import com.secondhandshop.springmvc.model.InputProduct;
import com.secondhandshop.springmvc.model.Product;


public interface InputProductDao {

	InputProduct findById(int id);
	
	List<InputProduct> findBySupplierId(int id);
	
	List<InputProduct> findByLocationId(int id);
	
	void save(InputProduct inputProduct);
	
	void deleteById(int id);
	
	List<InputProduct> findAllInputProducts();
	
	List<Product> findProductsByInputProductId(int id);

}

