package it.savethemoney.model;

public interface Objectives {
	
	/**
	 * 
	 * @param amount to be deposited for every objectives
	 */
	void deposit(double amount) throws IllegalArgumentException; //genera eccezione
	
	/**
	 * 
	 * @param amount to be withdraw for every objectives
	 */
	void withdraw(double amount) throws IllegalArgumentException; //genera eccezione
	
	
	Double getGoalAmount();
	
	Double getPaidAmount();
	
}
