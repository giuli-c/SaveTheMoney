package it.savethemoney.implementation;

import it.savethemoney.model.AbstractPayments;
import it.savethemoney.model.AccountBalance;

public class Withdraw extends AbstractPayments{

	private final static double WITHDRAW_FEE = 0.20;
	
	public Withdraw(AccountBalance accountBalance) {
		super(accountBalance, WITHDRAW_FEE);
	}

}
