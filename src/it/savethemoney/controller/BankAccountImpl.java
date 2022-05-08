package it.savethemoney.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import it.savethemoney.implementation.AccountBalanceImpl;
import it.savethemoney.implementation.CategoryImpl;
import it.savethemoney.implementation.ExpenseImpl;
import it.savethemoney.implementation.ObjectivesImpl;
import it.savethemoney.implementation.PresentElementException;
import it.savethemoney.implementation.ServicesImpl;
import it.savethemoney.model.AccountBalance;
import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;
import it.savethemoney.model.Services;
import it.savethemoney.model.Transactions;

public class BankAccountImpl implements BankAccount {

	private Set<ObjectivesImpl> objectivesSet;
	private Set<Category> categorySet;
	private List<Transactions> transactionList;
	private Services paymentServices;
	private AccountBalanceImpl accountBalance;
	
	public BankAccountImpl(String name, Double balance) {
		this.objectivesSet 		= new LinkedHashSet<>();
		this.categorySet 		= new LinkedHashSet<>();
		this.transactionList 	= new ArrayList<>();
		this.accountBalance 	= new AccountBalanceImpl(name, balance);
		this.paymentServices 	= new ServicesImpl(this.accountBalance);
	}
	
	@Override
	public void newObjective(String name, Double amount) throws PresentElementException {
		if(!this.objectivesSet.add(new ObjectivesImpl(name, amount)))
			throw new PresentElementException("ATTENZIONE! L'obbiettivo che vuoi inserire è già presente");
	}

	@Override
	public void removeObjective(Objectives o) throws NullPointerException {
		if(!this.objectivesSet.remove(o))
			throw new NullPointerException("ATTENZIONE! L'obbiettivo che vuoi rimuovere non esiste!");
	}

	@Override
	public void newCategory(String name) throws PresentElementException {
		if(!this.categorySet.add(new CategoryImpl(name)))
				throw new PresentElementException("ATTENZIONE! La categoria che vuoi inserire è già presente!");
	}

	@Override
	public void removeCategory(Category c) throws NullPointerException {
		if(!this.categorySet.remove(c))
			throw new NullPointerException("ATTENZIONE! La categoria che vuoi rimuovere non esiste!");
	}

	private Category findCategory(Category c) {
		return this.categorySet.stream()
								.filter(cat -> cat.equals(c))
								.findFirst()
								.get();
	}
	
	@Override
	public void addExpense(String name, String date, double amount, Category c) {
		this.findCategory(c).addExpense(new ExpenseImpl(name, date, amount));
	}

	@Override
	public void removeExpense(Category c, Expense e) {
		this.findCategory(c).removeExpense(e);
	}

	@Override
	public void viewObjectives() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewExpenses() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCategories() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewTransaction() {
		// TODO Auto-generated method stu		
	}
	
	@Override
	public String getName() {
		return accountBalance.getName();
	}
	
	@Override
	public AccountBalance getAccountBalance() {
		return accountBalance;
	}

	@Override
	public Set<ObjectivesImpl> getObjectiveSet() {
		return this.objectivesSet;				
	}
}
