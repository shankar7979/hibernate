import java.util.List;

import pack.User;
import pack.UserDAOImpl;

public class testUser {
	public static void main(String[] args) {
		try {
			UserDAOImpl udi = new UserDAOImpl();
			udi.addUser(2009, "ram", 20000);
			System.out.println("data added");
			udi.findUser(219);
			List<User> list = udi.showAll();
			for (User user : list) {
				System.out.println(user.getUid() + "\t" + user.getName() + "\t"
						+ user.getSalary());
			}
udi.updateUser(222, "geeta", 10000);
//udi.removeUser(222);
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}
}
