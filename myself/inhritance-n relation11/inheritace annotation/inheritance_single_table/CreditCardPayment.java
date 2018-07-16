package inheritance_single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("credit payment")
public class CreditCardPayment extends Payment {
	public CreditCardPayment(double amount) {
		super(amount);
	}
}