import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Customer {
	int id;
	String name;

}

public class Test {
	public static void main(String[] args) {
		List<Customer> list1 = new ArrayList<Customer>();
		// Set<Customer> list1 = new HashSet<Customer>();
		Customer customer = new Customer();
		customer.id = 1001;
		customer.name = "ram kumar";

		list1.add(customer);
		list1.add(customer);
		list1.add(customer);

		for (Customer customer3 : list1) {
			System.out.println(customer3.id + "\t" + customer3.name);
		}
	}
}
