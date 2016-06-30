package com.secondhandshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.secondhandshop.springmvc.dao.InputProductDao;
import com.secondhandshop.springmvc.dao.ProductDao;
import com.secondhandshop.springmvc.dao.SupplierDao;
import com.secondhandshop.springmvc.model.InputProduct;
import com.secondhandshop.springmvc.model.Product;
import com.secondhandshop.springmvc.model.Supplier;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;

	public Product findById(int id) {
		return dao.findById(id);
	}

	public void saveProduct(Product ip) {
		dao.save(ip);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateProduct(Product inp_prod) {
		Product entity = dao.findById(inp_prod.getId());
		if(entity!=null){
			entity.setProductPrice(inp_prod.getProductPrice());
			entity.setCodeProduct(inp_prod.getCodeProduct());
			entity.setDescription(inp_prod.getDescription());
		}
	}

	
	public void deleteSupplierById(int id) {
		dao.deleteById(id);
	}
	
	@Override
	public List<Product> findAllProducts() {
		return dao.findAllProducts();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findProductsByInputProductId(int id) {
		return dao.findProductsByInputProductId(1);
	}
}
