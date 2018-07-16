package org.com.bean;

public class Forum {

	private int id;
	private String name;
	private String location;
	
	public Forum(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public void forumInfo(){
		System.out.println("forum id is "+id);
		System.out.println("forum name is "+name);
	System.out.println("forum location is "+location);
	}	
}
