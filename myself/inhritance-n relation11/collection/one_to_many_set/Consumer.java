package one_to_many_set;

import java.util.Set;

public class Consumer {
	private int id;
	private String name;

	private Set<Complain> cset;

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

	public Set<Complain> getCset() {
		return cset;
	}

	public void setCset(Set<Complain> cset) {
		this.cset = cset;
	}

}
