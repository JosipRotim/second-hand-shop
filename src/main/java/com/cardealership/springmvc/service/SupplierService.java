package com.cardealership.springmvc.service;

import java.util.List;

import com.cardealership.springmvc.model.Supplier;


public interface SupplierService {
	
	Supplier findById(int id);
	
	Supplier findByCode(String code);
	
	void saveSupplier(Supplier sup);
	
	void updateSupplier(Supplier sup);
	
	void deleteUserByCode(String code);

	List<Supplier> findAllSuppliers(); 
	
	boolean isSupplierCodeUnique(Integer id, String code);

}