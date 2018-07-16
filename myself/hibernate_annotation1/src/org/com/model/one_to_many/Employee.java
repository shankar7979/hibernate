package org.com.model.one_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Employee {
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	 @Column(name = "emp_id")
	private int id;
	private String name;
	private float salary;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	// @Cascade(org.hibernate.annotations.CascadeType.ALL)
	//@IndexColumn(name = "idx1")
	// @PrimaryKeyJoinColumn(name = "addr_id")
	private List<Address> elist;

	public List<Address> getElist() {
		return elist;
	}

	public void setElist(List<Address> elist) {
		this.elist = elist;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
