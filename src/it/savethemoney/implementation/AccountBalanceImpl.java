package it.savethemoney.implementation;

import it.savethemoney.model.AccountBalance;

public class AccountBalanceImpl implements AccountBalance {

	private double balance;
	
	public AccountBalanceImpl(double balanceValue) {
		
		this.balance = balanceValue;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void addBalance(double amount) {
		this.balance += amount;
	}
}
