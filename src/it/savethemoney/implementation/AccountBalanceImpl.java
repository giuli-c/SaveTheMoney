package it.savethemoney.implementation;

import it.savethemoney.model.AbstractData;
import it.savethemoney.model.AccountBalance;

public class AccountBalanceImpl extends AbstractData implements AccountBalance {

	private Double balance;
	
	public AccountBalanceImpl(String name, Double balanceValue) {
		super(name);
		this.balance = balanceValue;
	}
	
	@Override
	public Double getBalance() {
		return balance;
	}
	
	@Override
	public Double addBalance(double amount) {
		return this.balance += amount;
	}
}
