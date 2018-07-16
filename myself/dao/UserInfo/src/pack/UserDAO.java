package pack;

import java.util.List;

public interface UserDAO {
	void addUser(int uid, String name, int salary);

	void updateUser(int uid, String name, int salary);

	void findUser(int uid);
	void removeUser(int uid);

	List<User> showAll();
}
