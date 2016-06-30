package com.secondhandshop.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="type_product")
public class ProductType {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_product_id")
	private Integer id;

	@NotEmpty
	@Column(name="type_product", nullable=false)
	private String typeProduct;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeproduct) {
		this.typeProduct = typeproduct;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ProductType))
            return false;
        ProductType other = (ProductType) obj;
        if (id != other.id)
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", typeProduct=" + typeProduct + "]";
	}


	
}
