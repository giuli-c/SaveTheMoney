package it.savethemoney.model;

public interface Objectives {
	
	/**
	 * 
	 * @param amount to be deposited for every objectives
	 */
	void deposit(double amount); //genera eccezione
	
	/**
	 * 
	 * @param amount to be withdraw for every objectives
	 */
	void withdraw(double amount); //genera eccezione
	
	/**
	 * 
	 * @return the current balance for every objectives
	 */
	double getGoalAmount();
	
	double getPaidAmount();
	
}
