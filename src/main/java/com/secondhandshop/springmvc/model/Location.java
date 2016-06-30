package com.secondhandshop.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="location")
public class Location {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_id")
	private Integer id;

	@NotEmpty
	@Column(name="location_mark", unique=true, nullable=false)
	private String locationMark;

	@NotEmpty
	@Column(name="address", nullable=false)
	private String address;
	
	@NotEmpty
	@Column(name="city", nullable=false)
	private String city;
	
	@NotEmpty
	@Column(name="phone", nullable=false)
	private Integer phone;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocationMark() {
		return locationMark;
	}

	public void setLocationMark(String locmark) {
		this.locationMark = locmark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adr) {
		this.address = adr;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String cty) {
		this.city = cty;
	}
	
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
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
		if (!(obj instanceof Location))
			return false;
		Location other = (Location) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationMark == null) {
			if (other.locationMark != null)
				return false;
		} else if (!locationMark.equals(other.locationMark))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Location [id=" + id + ", locationMark=" + locationMark + ", address=" + address + ", city=" + city
                + ", phone=" + phone + "]";
    }


	
}
