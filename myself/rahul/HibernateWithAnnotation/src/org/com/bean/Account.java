package org.com.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Account {
	private String description;

	@EmbeddedId
	private AccountPk id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountPk getId() {
		return id;
	}

	public void setId(AccountPk id) {
		this.id = id;
	}

public static class AccountPk implements Serializable{
		private int myid;
		private String name;

		public int getMyid() {
			return myid;
		}

		public void setMyid(int myid) {
			this.myid = myid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
