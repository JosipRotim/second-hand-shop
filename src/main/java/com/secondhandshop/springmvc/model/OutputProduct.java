package com.secondhandshop.springmvc.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="output_product")
public class OutputProduct {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="output_product_id")
	private Integer id;

	@NotEmpty
	@Column(name="date_of_exit", nullable=false)
	private Date dateOfExit;
	
	@NotEmpty
	@Column(name="summed_price", nullable=false)
	private Double summedPrice;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getExitDate() {
		return dateOfExit;
	}

	public void setExitDate(Date date) {
		this.dateOfExit = date;
	}
	
	public Double getSummedPrice() {
		return summedPrice;
	}

	public void setSummedPrice(Double summprice) {
		this.summedPrice = summprice;
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
        if (!(obj instanceof OutputProduct))
            return false;
        OutputProduct other = (OutputProduct) obj;
        if (id != other.id)
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "OutputProduct [id=" + id + ", date=" + dateOfExit + ", SummPrice=" + summedPrice + "]";
	}


	
}
