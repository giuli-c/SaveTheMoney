package it.savethemoney.controller;

import it.savethemoney.implementation.PresentElementException;
import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;

public interface BankAccount {
	
	void newObjective(String name, int amount) throws PresentElementException; //genera eccezione
	
	/**
	 * 
	 * @param o = objective to remove
	 */
	void removeObjective(Objectives o) throws NullPointerException; //genera eccezione
	
	
	void newCategory(String name) throws PresentElementException; //genera eccezioni
	
	/**
	 * 
	 * @param c = category to remove
	 */
	void removeCategory(Category c) throws NullPointerException; //genera eccezioni
	
	
	void addExpense(String name, String date, double amount, Category c);	//genera eccezioni
	
	/**
	 * 
	 * @param e = expense to remove
	 */
	void removeExpense(Category c, Expense e);	//genera eccezioni
	
	
	void viewObjectives();
	
	void viewExpenses();
	
	void viewCategories();
	
	void viewTransaction();
}
