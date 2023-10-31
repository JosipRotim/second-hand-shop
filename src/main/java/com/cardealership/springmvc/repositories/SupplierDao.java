package com.cardealership.springmvc.repositories;

import java.util.List;

import com.cardealership.springmvc.model.Supplier;


public interface SupplierDao {

	Supplier findById(int id);
	
	Supplier findByCode(String sso);
	
	void save(Supplier supplier);
	
	void deleteByCode(String sso);
	
	List<Supplier> findAllSuppliers();

}

