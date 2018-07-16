package one_to_many_array;

public class Book {

	private int  id;
	private String name;
	private Story story[];

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
	public Story[] getStory() {
		return story;
	}
	public void setStory(Story[] story) {
		this.story = story;
	}
	
	
	
}
