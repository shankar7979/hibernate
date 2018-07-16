public class Child {

    private Long id;
    private int cage;
    private String cname;
    Parent parent=new Parent();
    public Child() {}

    public Child(int cage, String cname) {
		super();
		this.cage = cage;
		this.cname = cname;		
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
  
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
