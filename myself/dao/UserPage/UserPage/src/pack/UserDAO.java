package pack;

import java.util.List;

public interface UserDAO {
	void addUser(int uid, String name, int salary);

	boolean updateUser(int uid, String name, int salary);

	User findUser(int uid);

	boolean removeUser(int uid);

	List<User> showAll();
}
