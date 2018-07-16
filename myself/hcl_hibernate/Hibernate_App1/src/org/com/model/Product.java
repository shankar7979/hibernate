package org.com.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="BookProduct")
public class Product {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="book_seq1")
	@SequenceGenerator
(name="book_seq1", sequenceName="book_seq1", allocationSize=2)*/
	
	private int id;
	@Column
	(length=20, unique=true, nullable=false, name="p_name")
	private String name;
	
	@Column(length=10)
	private float cost;
	
	@Temporal(TemporalType.DATE)
	//@Temporal(TemporalType.TIMESTAMP)
	private Date publish_date;
	
	
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	
	
}
