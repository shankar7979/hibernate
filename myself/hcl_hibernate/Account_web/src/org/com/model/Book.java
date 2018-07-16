package org.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int isbn;
	@Column(length = 20)
	private String name;
	private float cost;

	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="ch_id")
	private List<Chapter> c_list;

	
	public List<Chapter> getC_list() {
		return c_list;
	}

	public void setC_list(List<Chapter> c_list) {
		this.c_list = c_list;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
