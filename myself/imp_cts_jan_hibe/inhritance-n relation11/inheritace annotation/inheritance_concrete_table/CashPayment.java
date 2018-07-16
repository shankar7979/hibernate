package inheritance_concrete_table;

import javax.persistence.Entity;

@Entity
public class CashPayment extends Payment {
	private String cashType = "Cash Payment";

	public CashPayment(double amount) {
		super(amount);
	}
}