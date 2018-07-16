public class CreditCardPayment extends Payment {
	private String creditCardType = "Credit payment";

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public CreditCardPayment(double amount) {
		super(amount);
	}

}
