package pack;


import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String name;

	public Phone() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}