package inheritance_single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cash payment")
public class CashPayment extends Payment {
	public CashPayment(double amount) {
		super(amount);
	}
	
	
}