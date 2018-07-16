package pack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String name;
	
	@OneToMany(cascade = { CascadeType.ALL })
	// @JoinColumn(name = "phone_id")
	List<Phone> plist = new ArrayList<Phone>();

	public List<Phone> getPlist() {
		return plist;
	}

	public void setPlist(List<Phone> plist) {
		this.plist = plist;
	}

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

	void addPhone(Phone ph) {
		plist.add(ph);
	}

	List<Phone> getPhone() {
		return plist;
	}
}