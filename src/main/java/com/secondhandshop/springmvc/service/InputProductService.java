package com.cardealership.springmvc.service;

import java.util.List;

import com.cardealership.springmvc.model.InputProduct;
import com.cardealership.springmvc.model.Product;
import com.cardealership.springmvc.model.Supplier;


public interface InputProductService {
	
	InputProduct findById(int id);
	
	List<InputProduct> findBySupplierId(int id);
	
	void saveInputProduct(InputProduct ip);
	
	void updateInputProduct(InputProduct ip);
	
	void deleteInputProductById(int id);

	List<InputProduct> findAllInputProducts(); 

}