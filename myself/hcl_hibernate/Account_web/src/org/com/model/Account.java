package org.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries
  (
		  {@NamedQuery(name="findall", query="from Account"),
		  @NamedQuery(name="search", query="from Account a where a.id=:id"),
		  @NamedQuery(name="search1", query="from Account a where a.id=?")
		  
		  }
 )

public class Account {

	@Id
	private int id;
	
	private String name;
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	private String city;
	
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
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
