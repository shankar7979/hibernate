package org.com.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Customer {

	@EmbeddedId
	private CustomerKey customerKey;
	private String name;
	private String location;

	public CustomerKey getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(CustomerKey customerKey) {
		this.customerKey = customerKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
