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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="product")
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer id;

	@OneToOne
    @JoinColumn(name="type_product_id", unique=true, nullable=false)
    private ProductType productType;

	@NotEmpty
	@Column(name="code_product", nullable=false)
	private String codeProduct;

	@OneToOne
    @JoinColumn(name="age_group_id", unique=true,nullable=false)
	private AgeGroup ageGroup;
	
	@NotEmpty
	@Column(name="product_size", nullable=false)
	private String productSize;
	
	@NotEmpty
	@Column(name="product_price", nullable=false)
	private Double productPrice;

	@NotEmpty
	@Column(name="description", nullable=true)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "input_product_id")
	//@JsonBackReference
    private InputProduct inputProduct;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeproduct) {
		this.codeProduct = codeproduct;
	}
	
	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String ps) {
		this.productSize = ps;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productprice) {
		this.productPrice = productprice;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	
	@JsonIgnore
	 public InputProduct getInputProduct() {
        return inputProduct;
    }
 
    public void setInputProduct(InputProduct input_product) {
        this.inputProduct = input_product;
    }
    
    public ProductType getProductType() {
        return productType;
    }
 
    public void setProductType(ProductType producttype) {
        this.productType = producttype;
    }
    
    public AgeGroup getAgeGroup() {
        return ageGroup;
    }
 
    public void setAgeGroup(AgeGroup agegroup) {
        this.ageGroup = agegroup;
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
        if (!(obj instanceof Product))
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", codeProduct=" + codeProduct
				+ ", productSize=" + productSize + ", productPrice=" + productPrice
				+ ", description=" + description + "]";
	}


	
}
