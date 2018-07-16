public abstract class Payment {
    private long paymentId = 0 ;
    private double amount=0;
       
   public Payment(double amount) {
    this.amount=amount;
    }
    
    public long getpaymentId() {
      return paymentId;
    }

    public void setpaymentId(long paymentId) {
      this.paymentId = paymentId;
    }

    public double getAmount() {
	return this.amount;
    }

    public void setAmount(double amount) {
      this.amount = amount;
    }

  }
