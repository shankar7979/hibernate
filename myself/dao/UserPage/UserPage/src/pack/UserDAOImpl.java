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
			// tr = session.beginTransaction();
			usr = new User();
			usr.setUid(uid);
			usr.setName(name);
			usr.setSalary(salary);
			// tr.begin();
			session.save(usr);
			session.flush();
			// tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
		}
	}

	public User findUser(int uid) {
		// usr = (User) session.get(User.class, uid);
		Query query = session.createQuery("from User where uid=?");
		query.setInteger(0, uid);
		usr = (User) query.uniqueResult();
		return usr;
	}

	List<User> list;

	@Override
	public List<User> showAll() {
		list = new ArrayList<User>();
		Query query = session.createQuery("from User");

		list = query.list();
		return list;
	}

	@Override
	public boolean updateUser(int uid, String name, int salary) {
		usr = (User) session.load(User.class, uid);
		if (usr != null) {
			usr.setUid(uid);
			usr.setSalary(salary);
			usr.setName(name);
			session.update(usr);
			session.flush();
			System.out.println("User Uid " + usr.getUid() + " is updated");
		return true;
		} else {
			System.out.println("  User Id not available");
		return false;
		}
	}

	@Override
	public boolean removeUser(int uid) {

		usr = (User) session.get(User.class, uid);
		if (usr != null) {
			session.delete(usr);
			session.flush();
			return true;
		} else {
			return false;
		}
	}
}
