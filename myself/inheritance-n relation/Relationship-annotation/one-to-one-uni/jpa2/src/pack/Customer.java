package pack;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String name;

	@OneToOne(cascade={CascadeType.ALL})
	   @JoinColumn(name="PHONE_ID")
	  
	private Phone phone;

    public Customer() {
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

	public Phone getPhone() {
		return this.phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
}