package org.com.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private float salary;
	private Date dob;
    private Time entry_time;
    
	public Date getDob() {
		return dob;
	}
	public Time getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Time entry_time) {
		this.entry_time = entry_time;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
