package it.savethemoney.implementation;

import it.savethemoney.model.AbstractPayments;
import it.savethemoney.model.AccountBalance;
import it.savethemoney.model.Services;

public class ServicesImpl implements Services{

	private AccountBalance account;
	private AbstractPayments transfer;
	private AbstractPayments withdraw;
	private AbstractPayments payment;
	
	public ServicesImpl(AccountBalance accountBalance) {
		this.account 	= accountBalance;
		this.transfer 	= new Transfer(this.account);
		this.withdraw 	= new Withdraw(this.account);
		this.payment 	= new Payment(this.account);
	}
	
	@Override
	public void deposit(double amount) {
		this.account.addBalance(amount);
	}

	@Override
	public void payTransfer(double value) {
		this.payPrivate(value, this.transfer);		
	}

	@Override
	public void payWithdraw(double value) {
		this.payPrivate(value, this.withdraw);	
	}

	@Override
	public void payPayment(double value) {
		this.payPrivate(value, this.payment);	
	}

	private void payPrivate(double value, AbstractPayments p) {
		p.pay(value);
	}
}
