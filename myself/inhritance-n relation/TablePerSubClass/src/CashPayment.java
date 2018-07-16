public class CashPayment extends Payment{
private String cashType="Cash Payment";
    
    public String getCashType() {
	return cashType;
}

public void setCashType(String cashType) {
	this.cashType = cashType;
}
	public CashPayment(double amount)    { 
    	super(amount);
   }		 
    
    

    

  }
