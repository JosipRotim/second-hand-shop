package com.secondhandshop.springmvc.service;

import java.util.List;

import com.secondhandshop.springmvc.model.InputProduct;
import com.secondhandshop.springmvc.model.Product;
import com.secondhandshop.springmvc.model.Supplier;


public interface InputProductService {
	
	InputProduct findById(int id);
	
	List<InputProduct> findBySupplierId(int id);
	
	void saveInputProduct(InputProduct ip);
	
	void updateInputProduct(InputProduct ip);
	
	void deleteInputProductById(int id);

	List<InputProduct> findAllInputProducts(); 

}