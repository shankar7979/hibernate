package pack;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	SessionFactory sf;
	Session session;
	Transaction tr;
	User usr;

	public UserDAOImpl() {
		try {
			sf = HibernateUtil.getSessionFactory();
			session = sf.openSession();
		} catch (HibernateException e) {
		}
	}

	public void addUser(int uid, String name, int salary) {
		try {
		//	tr = session.beginTransaction();
			usr = new User();
			usr.setUid(uid);
			usr.setName(name);
			usr.setSalary(salary);
			//tr.begin();
			session.save(usr);
			session.flush();
			//tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
		}
	}

	public void findUser(int uid) {
		
		usr = (User) session.get(User.class, uid);
		if (usr != null) {
			System.out.println("user found");
			System.out.println("User Name "+usr.getName());
			System.out.println("User Salary "+usr.getSalary());
			System.out.println("User Uid "+usr.getUid());
		}
		else{
		System.out.println("wrong User Id");	
		}
	}
List<User> list;
	@Override
	public List<User> showAll() {
	list=new ArrayList<User>();
	Query query=session.createQuery("from User");
	
	list=query.list();	
	return list;
	}

	@Override
	public void updateUser(int uid, String name, int salary) {
		usr = (User) session.load(User.class, uid);
		if (usr != null) {
			usr.setUid(uid);
			usr.setSalary(salary);
			usr.setName(name);
			session.update(usr);
			session.flush();
			System.out.println("User Uid "+usr.getUid()+" is updated");
		}
		else{
		System.out.println("  User Id not available");	
		}	
	}

	@Override
	public void removeUser(int uid) {
		usr = (User) session.get(User.class, uid);
		if (usr != null) {
			session.delete(usr);
			session.flush();
		}
		else{
		System.out.println("  User Id not available");	
		}		
	}
}
