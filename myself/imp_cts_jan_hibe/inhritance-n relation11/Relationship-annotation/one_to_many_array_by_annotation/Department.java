package org.com.one_to_many_array_by_annotation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String location;

	// @OneToMany(cascade={CascadeType.ALL})
	@ManyToMany
	@JoinColumn(name = "key_id")
	@IndexColumn(name = "idx1")
	private Staff staff[];

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Staff[] getStaff() {
		return staff;
	}

	public void setStaff(Staff[] staff) {
		this.staff = staff;
	}

}
