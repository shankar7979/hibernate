package org.com.bean;

public class SurveyImpl  implements Survey{
	
	private int id;
	private String name;
	private String state;
	private String location;
	
	public SurveyImpl
	(String location, String name, String state) {
		this.location = location;
		this.name = name;
		this.state = state;
	}
	
	public SurveyImpl(int id, String name, String state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	

	@Override
	public String getSurveyInfo() {
		return "Survey Information"
	+"\n Id is "+id
	+"\nName is "+name
	+"\nstate is "+state;
	}
}
