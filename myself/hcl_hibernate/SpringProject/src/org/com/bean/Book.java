package org.com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Book {

	private int isbn;
	private String name;
	private float cost;
	
	@Autowired
	private Story story;

	
	public void setStory(Story story) {
		this.story = story;
	}
	
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Required
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	@Override
	public String toString() {
		return "Book Informatio "+
	     "\n isbn is "+isbn+
	     "\n name is "+name+
	     "\ncost is "+cost+"\n\n"+story	     
	     ;
	}
	
}
