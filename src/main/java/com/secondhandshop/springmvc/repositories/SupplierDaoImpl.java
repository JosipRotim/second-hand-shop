package com.secondhandshop.springmvc.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.secondhandshop.springmvc.model.Supplier;



@Repository("supplierDao")
public class SupplierDaoImpl extends AbstractDao<Integer, Supplier> implements SupplierDao {

	public Supplier findById(int id) {
		Supplier supplier = getByKey(id);
		//if(supplier!=null){
		//	Hibernate.initialize(supplier.getSupplierProfiles());
		//}
		return supplier;
	}

	public Supplier findByCode(String sso) {
		System.out.println("CodeSupplier : "+sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code_supplier", sso));
		Supplier supplier = (Supplier)crit.uniqueResult();
		//if(supplier!=null){
		//	Hibernate.initialize(supplier.getSupplierProfiles());
		//}
		return supplier;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> findAllSuppliers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Supplier> suppliers = (List<Supplier>) criteria.list();
		// No need to fetch Suppliers since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of SupplierProfiles if you want.
		/*
		for(Supplier supplier : suppliers){
			Hibernate.initialize(Supplier.getSupplierProfiles());
		}*/
		return suppliers;
	}

	public void save(Supplier supplier) {
		persist(supplier);
	}

	public void deleteByCode(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("codeSupplier", sso));
		Supplier supplier = (Supplier)crit.uniqueResult();
		delete(supplier);
	}

}
