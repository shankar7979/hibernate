package org.com.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Leader {

	private int id;
	private String name;
	private int ssnb;
	@Resource
	(name="speech1")
	
	//@Autowired	
	//@Qualifier(value="speech1")
	private Speech speech;

	@PostConstruct
	public void startup(){
		System.out.println("leader startup called");
		
		id=7887;
		name="shyam kumar";
		ssnb=6776;
	}
	
	@PreDestroy
	public void cleanup(){
		System.out.println("clean up called");
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

	public int getSsnb() {
		return ssnb;
	}

	public void setSsnb(int ssnb) {
		this.ssnb = ssnb;
	}

	public Speech getSpeech() {
		return speech;
	}

	public void setSpeech(Speech speech) {
		this.speech = speech;
	}
	
	
}
