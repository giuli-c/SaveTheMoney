package it.savethemoney.implementation;

import it.savethemoney.controller.BankAccount;
import it.savethemoney.controller.BankAccountImpl;
import it.savethemoney.model.User;

public class UserImpl implements User{

	private String name;
	private BankAccount account;
	
	public UserImpl(String userName, Double accountBalance) {
		this.name = userName;
		this.account = new BankAccountImpl(userName, accountBalance);
	}

	public String getName() {
		return name;
	}

	public BankAccount getAccount() {
		return account;
	}
}
