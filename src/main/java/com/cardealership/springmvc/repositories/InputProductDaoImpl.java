package com.cardealership.springmvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cardealership.springmvc.model.InputProduct;
import com.cardealership.springmvc.model.Product;


@Repository("inputProductDao")
public class InputProductDaoImpl extends AbstractDao<Integer, InputProduct> implements InputProductDao {

	public InputProduct findById(int id) {
		InputProduct inProduct = getByKey(id);
		//if(supplier!=null){
		//	Hibernate.initialize(supplier.getSupplierProfiles());
		//}
		return inProduct;
	}

	@SuppressWarnings("unchecked")
	public List<InputProduct> findAllInputProducts() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("dateOfEntrance"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<InputProduct> inputProducts = (List<InputProduct>) criteria.list();
		
		// No need to fetch Suppliers since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of SupplierProfiles if you want.
		/*
		for(Supplier supplier : suppliers){
			Hibernate.initialize(Supplier.getSupplierProfiles());
		}*/
		return inputProducts;
	}

	public void save(InputProduct inputProduct) {
		persist(inputProduct);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		InputProduct inputProduct = (InputProduct)crit.uniqueResult();
		delete(inputProduct);
	}

	@Override
	public List<InputProduct> findByLocationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<InputProduct> findBySupplierId(int supplierId) {
		System.out.println("SupplierId : "+supplierId);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("supplier.supplierId", supplierId));
		
		List<InputProduct> InputProducts = crit.list();
		
		//if(supplier!=null){
		//	Hibernate.initialize(supplier.getSupplierProfiles());
		//}
		return InputProducts;
	}

	@Override
	public List<Product> findProductsByInputProductId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
