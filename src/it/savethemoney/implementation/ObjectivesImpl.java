package it.savethemoney.implementation;

import java.util.Objects;

import it.savethemoney.model.AbstractData;
import it.savethemoney.model.AccountBalance;
import it.savethemoney.model.Objectives;
import it.savethemoney.model.Services;

public class ObjectivesImpl extends AbstractData implements Objectives {
	
	private Services paymentServices;
	private AccountBalance objectiveAccount;
	private double goalAmount;					// importo da raggiungere
	
	public ObjectivesImpl(final String nameData, final double amount) {
		super(nameData);
		this.goalAmount 	  = amount;
		this.objectiveAccount = new AccountBalanceImpl(0);
		this.paymentServices  = new ServicesImpl(this.objectiveAccount);
	}

	@Override
	public void deposit(final double amount) throws IllegalArgumentException {	// final perchè non andrò a modificare la variabile amount da depositare
		if(amount + this.objectiveAccount.getBalance() > this.goalAmount)
			throw new IllegalArgumentException("ATTENZIONE! Non puoi inserire l'importo di € " + amount);
	
		this.paymentServices.deposit(amount);
	}

	@Override
	public void withdraw(final double amount) throws IllegalArgumentException {
		this.paymentServices.payWithdraw(amount);
	}

	@Override
	public double getGoalAmount() {
		return this.goalAmount;
	}

	@Override
	public double getPaidAmount() {
		return this.objectiveAccount.getBalance();
	}

	public void modifyData(String newName, double newAmount) {
		super.modifyData(newName);
		this.goalAmount = newAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectivesImpl other = (ObjectivesImpl) obj;
		return this.getName() == other.getName();
	}

	
}
