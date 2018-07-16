package org.com.one_to_many_List_by_annotation;

import java.util.ArrayList;
import java.util.List;

import org.com.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) {

		SessionFactory factory = DatabaseUtil.retrieveSf();
		Session session = factory.openSession();

		Movie movie = new Movie();

		Character character1 = new Character();
		Character character2 = new Character();
		Character character3 = new Character();

		movie.setName("ramayana");
		character1.setName("ram");
		character2.setName("sita");
		character3.setName("ravana");

		List<Character> list = new ArrayList<>();
		list.add(character1);
		list.add(character2);
		list.add(character3);

		movie.setClist(list);

		Transaction tr=session.beginTransaction();

		session.save(movie);
		/*session.save(character1);
		session.save(character2);
		session.save(character3);
*/
		tr.commit();
	}
}
