package org.com;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Product {

	private int id;
	private String name;
	ProductDetail prdDetail;
	
	
	public ProductDetail getPrdDetail() {
		return prdDetail;
	}

	public void setPrdDetail(ProductDetail prdDetail) {
		this.prdDetail = prdDetail;
	}

	private Date dom;

	@Id
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
@Temporal(TemporalType.DATE)
	public Date getDom() {
		return dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}
	
	
}
