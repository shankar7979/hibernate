package bean;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@javax.persistence.SequenceGenerator(name="SEQ",sequenceName="seq2")
@Table
public class Stud implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ")
	private int roll;
	private String name;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
