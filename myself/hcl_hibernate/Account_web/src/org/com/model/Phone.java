package org.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	@Column(length = 20)
	private int imei;
	
	@Column(length = 20)
	private String model;
	
	@Column(length = 20)
	private float cost;
	
	@OneToOne(mappedBy="phone", cascade=CascadeType.ALL)
	Customer customer;	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getImei() {
		return imei;
	}

	public void setImei(int imei) {
		this.imei = imei;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
