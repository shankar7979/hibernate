import java.util.HashSet;
import java.util.Set;

import one_to_many_set.Complain;
import one_to_many_set.Consumer;
import one_to_one_primary_key.Customer;
import one_to_one_primary_key.Home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToMany_Set_Client {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Complain complain1 = new Complain();
		Complain complain2 = new Complain();
		Complain complain3 = new Complain();

		Consumer consumer = new Consumer();
		consumer.setName("amit kumar");
		complain1.setCname("tv issue");
		complain2.setCname("gas issue");
		complain3.setCname("electricity issue");

		Set<Complain> comp_set = new HashSet<Complain>();
		comp_set.add(complain1);
		comp_set.add(complain2);
		comp_set.add(complain3);

		consumer.setCset(comp_set);
		session.getTransaction().begin();
		session.save(consumer);

		session.save(complain1);
		session.save(complain2);
		session.save(complain3);

		session.getTransaction().commit();

		System.out
				.println("==================retrieval =======================");

		Consumer consumer2 = (Consumer) session.get(Consumer.class, 1);

		System.out.println("Comsumer info ");
		System.out.println(consumer2.getId() + "\t" + consumer2.getName());

		Set<Complain> cset11 = consumer2.getCset();

		System.out.println("complain info");

		for (Complain complain : cset11) {
			System.out.println(complain.getCid() + "\t" + complain.getCname());
		}
	}

}
