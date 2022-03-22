package it.savethemoney.model;

import it.savethemoney.controller.BankAccount;

public interface User {
	
	String getName();

	BankAccount getAccount();
	
}
