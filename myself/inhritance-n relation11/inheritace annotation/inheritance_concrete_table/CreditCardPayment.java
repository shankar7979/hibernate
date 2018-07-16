package inheritance_concrete_table;

import javax.persistence.Entity;

@Entity
public class CreditCardPayment extends Payment {
	private String creditCardType = "Credit payment";

	public CreditCardPayment(double amount) {
		super(amount);
	}
}
