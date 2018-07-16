package many_to_one;

public class Person {

	private int id;
	private String name;
	private Address addrress;

	public Address getAddrress() {
		return addrress;
	}

	public void setAddrress(Address addrress) {
		this.addrress = addrress;
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

}
