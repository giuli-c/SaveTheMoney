package it.savethemoney.model;

import java.util.List;

public interface Transactions {

	void addToTransaction(Expense e);
	
	List<Expense> getTransactions();
}
