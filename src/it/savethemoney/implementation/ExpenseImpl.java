package it.savethemoney.implementation;

import it.savethemoney.model.AbstractData;
import it.savethemoney.model.Expense;

public class ExpenseImpl extends AbstractData implements Expense {

	private String date;
	private double quantity;	
	
	public ExpenseImpl(final String nameData, final String date, final double quantity) {
		super(nameData);
		this.date 		= date;
		this.quantity 	= quantity;
	}

	@Override
	public String getDate() {
		return this.date;
	}

	@Override
	public double getQuantity() {
		return this.quantity;
	}

	public void modifyData(String newName, String newDate, double newQuantity) {
		super.modifyData(newName);
		this.date 		= newDate;
		this.quantity 	= newQuantity;
	}
}
