package it.savethemoney.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.savethemoney.model.Expense;
import it.savethemoney.model.Transactions;

public class TransactionImpl implements Transactions{

	private List<Expense> transactionsList;
	
	public TransactionImpl() {
		this.transactionsList = new ArrayList<>();
	}
	
	@Override
	public void addToTransaction(Expense e) {
		this.transactionsList.add(e);		
	}
	
	@Override
	public List<Expense> getTransactions() {
		return Collections.unmodifiableList(this.transactionsList);
	}
}
