package it.savethemoney.model;

public interface Expense {
	
	/**
	 * 
	 * @return the date for every expense
	 */
	String getDate();
	
	/**
	 * 
	 * @return the quantity for every expense
	 */
	double getQuantity();
}
