package org.com.bean;

public class NewsPaper {
	private int id;
	private String name;
	private float cost;

	public void Init(){
	System.out.println("news bean initialised ");	
	id=78878;
	name="Sakshi Paper";
	cost=5.0f;	
	}
	
	public void cleanUp(){
		System.out.println("destroy called ");
	id=0;
	name=null;
	cost=0;
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
