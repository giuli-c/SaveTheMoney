package it.savethemoney.view;

import it.savethemoney.model.AbstractData;
import it.savethemoney.model.Objectives;

public class ObjectivesImpl extends AbstractData implements Objectives {
	
	private double goalAmount;
	private double paidAmount;

	public ObjectivesImpl(final String nameData, final double amount) {
		super(nameData);
		this.goalAmount = amount;
	}

	@Override
	public void deposit(final double amount) {	// final perchè non andrò a modificare la variabile amount da depositare
		this.paidAmount += amount;	
	}

	@Override
	public void withdraw(final double amount) {
		this.paidAmount -= amount;
	}

	@Override
	public double getGoalAmount() {
		return this.goalAmount;
	}

	@Override
	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void modifyData(String newName, double newAmount) {
		super.modifyData(newName);
		this.goalAmount = newAmount;
	}

}
