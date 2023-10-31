package com.cardealership.springmvc.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="input_product")
public class InputProduct {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="input_product_id")
	private Integer id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inputProduct")
	//@JsonManagedReference
    private List<Product> products;

	@ManyToOne(optional = false)
    @JoinColumn(name = "supplier_id")
	@JsonBackReference
    private Supplier supplier;

	@NotEmpty
	@Column(name="date_of_entrance", nullable=false)
	private String dateOfEntrance;

	@NotEmpty
	@Column(name="input_price", nullable=false)
	private Double inputPrice;
	
	@NotEmpty
	@Column(name="pieces", nullable=false)
	private Integer pieces;
	
	@OneToOne
	@JoinColumn(name="location_id")
	private Location location;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateOfEntrance() {
		return dateOfEntrance;
	}

	public void setDateOfEntrance(String entrance) {
		this.dateOfEntrance = entrance;
	}

	public Double getInputPrice() {
		return inputPrice;
	}

	public void setInputPrice(Double inputPrice) {
		this.inputPrice = inputPrice;
	}

	public Integer getPieces() {
		return pieces;
	}

	public void setPieces(Integer piece) {
		this.pieces = piece;
	}
	
	public Location getLocation() {
        return location;
    }
 
    public void setLocation(Location loc) {
        this.location = loc;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }
 
    public void setSupplier(Supplier supp) {
        this.supplier = supp;
    }
    
    //@JsonIgnore
    public List<Product> getProducts() {
        return products;
    }
 
    public void setProducts(List<Product> products) {
        this.products = products;
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
        if (!(obj instanceof InputProduct))
            return false;
        InputProduct other = (InputProduct) obj;
        if (id != other.id)
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "InputProduct [id=" + id + ", dateOfEntrance=" + dateOfEntrance + ", inputPrice=" + inputPrice
				+ ", pieces=" + pieces + "]";
	}


	
}
