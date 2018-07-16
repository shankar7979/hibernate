package org.com.model;

import javax.persistence.*;

import java.util.*;

@Entity
public class Customer implements java.io.Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column(length=20)
	private String firstName;
	@Column(length=20)
	private String lastName;

	@OneToOne(cascade = { CascadeType.ALL })
	private CreditCard creditCard;

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
