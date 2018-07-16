package org.com.one_to_many_List_by_annotation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Index;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name = "movie_id")
	
	//@PrimaryKeyJoinColumn(name = "key_id")
	//@Cascade(org.hibernate.)
	private List<Character> clist;

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

	public List<Character> getClist() {
		return clist;
	}

	public void setClist(List<Character> clist) {
		this.clist = clist;
	}
}
