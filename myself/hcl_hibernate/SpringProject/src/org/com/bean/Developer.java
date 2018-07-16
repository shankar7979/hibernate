package org.com.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Developer {

	private int id;
	private String name;
	private float salary;
	private Project p_list;	
	private List<String> address;
	private Set<Integer> duration;
	private Map<String, String>  vehicle;
	private Properties birthday; 
	
	
	public Properties getBirthday() {
		return birthday;
	}
	public void setBirthday(Properties birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Map<String, String> vehicle) {
		this.vehicle = vehicle;
	}
	public Set<Integer> getDuration() {
		return duration;
	}
	public void setDuration(Set<Integer> duration) {
		this.duration = duration;
	}
	
		
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public Project getP_list() {
		return p_list;
	}
	public void setP_list(Project p_list) {
		this.p_list = p_list;
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
