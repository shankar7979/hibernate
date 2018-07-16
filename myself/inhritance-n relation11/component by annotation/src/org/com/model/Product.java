package org.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.com.util.PhoneKey;
import org.hibernate.annotations.GenericGenerator;

@IdClass(PhoneKey.class)
@Entity
@Table(name="User_product")
public class Product {

	@Id
	private String area;
	
	@Id
	private int ph_number;
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
    //@SequenceGenerator( name="emp_seq2", sequenceName="emp_seq2")
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getPh_number() {
		return ph_number;
	}
	public void setPh_number(int ph_number) {
		this.ph_number = ph_number;
	}
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="prd_id", length=7)
	private int id;
	
	@Column(name="prd_name", length=20, nullable=false)
	private String name;
	
	@Column(name="prd_cost", length=10, nullable=false)
	private float cost;
	
	@Temporal(TemporalType.DATE)
	private Date mfd;
		
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	
	
}
