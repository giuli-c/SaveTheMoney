package it.savethemoney.implementation;

import it.savethemoney.model.AbstractPayments;
import it.savethemoney.model.AccountBalance;

public class Payment extends AbstractPayments{

	public Payment(AccountBalance accountBalance) {
		super(accountBalance, 0);
	}

}
