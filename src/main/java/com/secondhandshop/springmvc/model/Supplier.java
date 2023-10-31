package com.cardealership.springmvc.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="supplier")
public class Supplier {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_id")
	private Integer supplierId;

	@NotEmpty
	@Column(name="code_supplier", unique=true, nullable=false)
	private String codeSupplier;
		
	@NotEmpty
	@Column(name="first_name", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="last_name", nullable=false)
	private String lastName;

	@NotEmpty
	@Column(name="oib", nullable=false)
	private Integer oib;
	
	@NotEmpty
	@Column(name="address", nullable=false)
	private String address;
	
	@NotEmpty
	@Column(name="ptt", nullable=false)
	private Integer ptt;

	@NotEmpty
	@Column(name="town", nullable=false)
	private String town;
	
	@NotEmpty
	@Column(name="email", nullable=false)
	private String email;
	
	@NotEmpty
	@Column(name="phone", nullable=false)
	private String phone;
	
	@NotEmpty
	@Column(name="fax", nullable=false)
	private String fax;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier")
    @JsonManagedReference
    private Set<InputProduct> inputProducts;
	
	public Integer getId() {
		return supplierId;
	}

	public void setId(Integer id) {
		this.supplierId = id;
	}

	public String getCodeSupplier() {
		return codeSupplier;
	}

	public void setCodeSupplier(String code) {
		this.codeSupplier = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getOIB() {
		return oib;
	}

	public void setOIB(Integer oi) {
		this.oib = oi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String adr) {
		this.address = adr;
	}
	
	public Integer getPtt() {
		return ptt;
	}

	public void setPtt(Integer pt) {
		this.ptt = pt;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public Set<InputProduct> getInputProducts() {
        return inputProducts;
    }
 
    public void setInputProducts(Set<InputProduct> inputProducts) {
        this.inputProducts = inputProducts;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
		result = prime * result + ((codeSupplier == null) ? 0 : codeSupplier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Supplier))
			return false;
		Supplier other = (Supplier) obj;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (codeSupplier == null) {
			if (other.codeSupplier != null)
				return false;
		} else if (!codeSupplier.equals(other.codeSupplier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + supplierId + ", codeSupplier=" + codeSupplier
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}


	
}
