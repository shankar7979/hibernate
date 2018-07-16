package org.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@Column(length=20)
	private String name;
	
	@OneToOne	(cascade={CascadeType.ALL},orphanRemoval=true)
	//@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	// @Cascade(org.hibernate.annotations.CascadeType.ALL)

	@JoinColumn(name="addr_id")	
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
