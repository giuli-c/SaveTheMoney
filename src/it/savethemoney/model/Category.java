package it.savethemoney.model;

import java.util.List;

public interface Category {
	
	/**
	 * 
	 * @return the list of expenses contained in each category
	 */
	List<Expense> expenseCategory(); 
	
	void addExpense(Expense e);
	
	void removeExpense(Expense e) throws NullPointerException;
}
