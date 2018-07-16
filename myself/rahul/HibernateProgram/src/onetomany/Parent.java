package onetomany;

import java.util.*;

public class Parent {

	private Long id;
	private int page;
	private String pname;

	private Set children = new HashSet();

	public Parent(int page, String pname) {
		this.page = page;
		this.pname = pname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}
	
	public void addChild(Child c) {
		children.add(c);
	}

}