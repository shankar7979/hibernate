<%@page import="java.util.List"%>
<%@page import="org.com.model.Address"%>
<%@page import="org.com.model.Person"%>
<%@page import="org.com.util.HibernateUtil"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>

<%!SessionFactory sf;
	Session session1;
	Transaction tr;
	Query qr;
	
	
	%>

<%
	sf = HibernateUtil.getSF();
	session1 = sf.openSession();

	Person person = new Person();
	Address address = new Address();

	person.setId(1001);
	person.setName("md. irfan ");

	address.setId(2003);
	
	address.setStreet("sector1");
	address.setCity("karimnagar");

	person.setAddress(address);

	tr = session1.beginTransaction();
	tr.begin();

	session1.save(person);
	session1.save(address);

	tr.commit();

	out.print("Record added");

List<Person> plist=	session1.createQuery("from Person").list();
	for(Person p:plist){
		Address addr1=p.getAddress();
	out.print("<br>"+p.getId()+"\t"+p.getName()+"\t city id "+addr1.getId()+"\t"+addr1.getStreet()+"\t"+addr1.getCity());	
	}

%>

