package com.cardealership.springmvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cardealership.springmvc.model.Product;


@Repository("ProductDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {
    
	public Product findById(int id) {
		Product inProduct = getByKey(id);
		//if(supplier!=null){
		//	Hibernate.initialize(supplier.getSupplierProfiles());
		//}
		return inProduct;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("description"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Product> products = (List<Product>) criteria.list();
		
		// No need to fetch Suppliers since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of SupplierProfiles if you want.
		/*
		for(Supplier supplier : suppliers){
			Hibernate.initialize(Supplier.getSupplierProfiles());
		}*/
		return products;
	}

	public void save(Product product) {
		persist(product);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Product product = (Product)crit.uniqueResult();
		delete(product);
	}

	@Override
	public List<Product> findProductsByInputProductId(int inputProductId) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		criteria.add(Restrictions.eq("id", 1));
		
		List<Product> products = (List<Product>) criteria.list();
		
		return products;
	}

}
