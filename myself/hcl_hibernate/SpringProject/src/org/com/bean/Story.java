package org.com.bean;

import org.springframework.stereotype.Component;

@Component
public class Story {

	private int pageno=87887;
	private String  strory_name="tom and jerry";
	private String story_type="v=cartoon story";
	
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public void setStrory_name(String strory_name) {
		this.strory_name = strory_name;
	}
	public void setStory_type(String story_type) {
		this.story_type = story_type;
	}	
	
	@Override
	public String toString() {
		return "Story  Information "+
	     "\n page no  is "+pageno+
	     "\n story_name  is "+strory_name+
	     "\nstory_type is "+story_type	     
	     ;
	}	
}
