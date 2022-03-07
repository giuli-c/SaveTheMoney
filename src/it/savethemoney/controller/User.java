package it.savethemoney.controller;

import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;

public interface User {
	
	void newObjective(String name, int amount); //genera eccezione
	
	/**
	 * 
	 * @param o = objective to remove
	 */
	void removeObjective(Objectives o); //genera eccezione
	
	
	void newCategory(String name); //genera eccezioni
	
	/**
	 * 
	 * @param c = category to remove
	 */
	void removeCategory(Category c); //genera eccezioni
	
	
	void addExpense(String name, String date, double amount, Category c);	//genera eccezioni
	
	/**
	 * 
	 * @param e = expense to remove
	 */
	void removeExpense(Category c, Expense e);	//genera eccezioni
	
	
	void viewObjectives();
	
	void viewExpenses();
	
	void viewCategories();
}
