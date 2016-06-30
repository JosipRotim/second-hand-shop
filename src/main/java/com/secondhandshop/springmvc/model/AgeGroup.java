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
@Table(name="age_group")
public class AgeGroup {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="age_group_id")
	private Integer id;

	@NotEmpty
	@Column(name="age", unique=true, nullable=false)
	private String age;

		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
        if (!(obj instanceof AgeGroup))
            return false;
        AgeGroup other = (AgeGroup) obj;
        if (id != other.id)
            return false;
        return true;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", Age=" + age + "]";
	}


	
}
