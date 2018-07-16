package org.com.one_to_many_map;

import java.util.HashMap;
import java.util.Map;

import org.com.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = DatabaseUtil.retrieveSf();
		Session session = factory.openSession();
		User user = new User();
		user.setId(10001);
		user.setName("madan kumar");

		Map<String, String> map1 = new HashMap<>();
		map1.put("bike", "pulsar");
		map1.put("tv", "samsung");

		User user1 = new User();

		user1.setId(10002);
		user1.setName("raman kumar");

		Map<String, String> map2 = new HashMap<>();
		map2.put("car", "BMW");
		map2.put("tv", "Sony");

		user.setMap1(map1);
		user1.setMap1(map2);

		Transaction tr = session.beginTransaction();

		session.save(user);
		session.save(user1);

		tr.commit();

	}
}
