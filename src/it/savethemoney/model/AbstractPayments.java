package it.savethemoney.model;

public abstract class AbstractPayments {
	
	private AccountBalance account;
	private double paymentFee;
	
	public AbstractPayments(AccountBalance accountBalance, double fee) {
		this.account 	= accountBalance;
		this.paymentFee = fee;
	}
	
	public void pay(double amount) {
		this.account.addBalance(-amount - this.paymentFee);
	}

}
