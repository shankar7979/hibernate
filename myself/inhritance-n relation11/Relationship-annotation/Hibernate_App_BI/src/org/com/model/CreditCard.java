package org.com.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class CreditCard implements java.io.Serializable {
	@Id
	@GeneratedValue
	private int id;
	@Column(length=20)
	private String nameOnCard;
	@OneToOne(mappedBy = "creditCard",cascade = { CascadeType.ALL })
	private Customer customer;

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
