package com.cardealership.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardealership.springmvc.repositories.SupplierDao;
import com.cardealership.springmvc.model.Supplier;

@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao dao;

	public Supplier findById(int id) {
		return dao.findById(id);
	}

	public Supplier findByCode(String code) {
		Supplier supplier= dao.findByCode(code);
		return supplier;
	}

	public void saveSupplier(Supplier supp) {
		dao.save(supp);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateSupplier(Supplier supplier) {
		Supplier entity = dao.findById(supplier.getId());
		if(entity!=null){
			entity.setCodeSupplier(supplier.getCodeSupplier());
			entity.setFirstName(supplier.getFirstName());
			entity.setLastName(supplier.getLastName());
			entity.setEmail(supplier.getEmail());
		}
	}

	public void deleteSupplierByCode(String code) {
		dao.deleteByCode(code);
	}

	public List<Supplier> findAllSuppliers() {
		
		return dao.findAllSuppliers();
	}

	public boolean isSupplierCodeUnique(Integer id, String sso) {
		Supplier sup = findByCode(sso);
		return ( sup == null || ((id != null) && (sup.getId() == id)));
	}

	@Override
	public void deleteUserByCode(String code) {
		// TODO Auto-generated method stub
		
	}
	
}
