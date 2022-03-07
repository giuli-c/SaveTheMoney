package it.savethemoney.implementation;

import java.util.Objects;

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
	public void deposit(final double amount) throws IllegalArgumentException {	// final perchè non andrò a modificare la variabile amount da depositare
		if(amount < 0 || amount + this.paidAmount > goalAmount)
			throw new IllegalArgumentException("ATTENZIONE! Non puoi inserire l'importo di € " + amount);
	
		this.paidAmount += amount;
	}

	@Override
	public void withdraw(final double amount) throws IllegalArgumentException {
		if(amount > paidAmount)
			throw new IllegalArgumentException("ATTENZIONE! Non puoi ritirare l'importo di € " + amount);
		
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
