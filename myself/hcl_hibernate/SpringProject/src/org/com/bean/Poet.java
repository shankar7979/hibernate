package org.com.bean;

public class Poet {

	private int id;
	private String name;
	private String language;
	private String state;
	private Poem poem;
		
	public void init_poet(){
		id=787878;
		name="ram dhari singh dinkar";
		language="hindi";
		state="Bihar";
	}
	
	
	
	public Poem getPoem() {
		return poem;
	}
	public void setPoem(Poem poem) {
		this.poem = poem;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
