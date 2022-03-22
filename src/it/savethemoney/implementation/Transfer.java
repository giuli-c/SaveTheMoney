package it.savethemoney.implementation;

import it.savethemoney.model.AbstractPayments;
import it.savethemoney.model.AccountBalance;

public class Transfer extends AbstractPayments{

	private static final double TRANSFER_FEE = 0.50;
	
	public Transfer(AccountBalance accountBalance) {
		super(accountBalance, TRANSFER_FEE);
	}

}
