package it.savethemoney.model;

import java.util.List;

public interface Category {
	
	/**
	 * 
	 * @return the list of expenses contained in each category
	 */
	List<Expense> expenseCategory(); 
	
	void addExpense(Expense e); //genera eccezioni
	
	void removeExpense(Expense e); // genera eccezioni
}
