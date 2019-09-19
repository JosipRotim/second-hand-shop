package com.secondhandshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhandshop.springmvc.repositories.InputProductDao;
import com.secondhandshop.springmvc.model.InputProduct;

@Service("inputProductService")
@Transactional
public class InputProductServiceImpl implements InputProductService{

	@Autowired
	private InputProductDao dao;

	public InputProduct findById(int id) {
		return dao.findById(id);
	}

	public void saveInputProduct(InputProduct ip) {
		dao.save(ip);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateInputProduct(InputProduct inp_prod) {
		InputProduct entity = dao.findById(inp_prod.getId());
		if(entity!=null){
			entity.setInputPrice(inp_prod.getInputPrice());
			entity.setDateOfEntrance(inp_prod.getDateOfEntrance());
			entity.setPieces(inp_prod.getPieces());
		}
	}

	
	public void deleteSupplierById(int id) {
		dao.deleteById(id);
	}

	public List<InputProduct> findAllInputProducts() {
		return dao.findAllInputProducts();
	}

	@Override
	public List<InputProduct> findBySupplierId(int id) {
		// TODO Auto-generated method stub
		return dao.findBySupplierId(id);
	}

	@Override
	public void deleteInputProductById(int id) {
		// TODO Auto-generated method stub
		
	}
}
