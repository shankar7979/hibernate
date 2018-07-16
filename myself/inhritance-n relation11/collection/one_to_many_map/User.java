package org.com.one_to_many_map;

import java.util.Map;

public class User {

	private int id;
	private String name;

	private Map<String, String> map1;

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

	public Map<String, String> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}
}