package it.savethemoney.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import it.savethemoney.implementation.CategoryImpl;
import it.savethemoney.implementation.ExpenseImpl;
import it.savethemoney.implementation.ObjectivesImpl;
import it.savethemoney.implementation.PresentElementException;
import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;

public class BankAccountImpl implements BankAccount {

	private Set<Objectives> objectivesSet;
	private Set<Category> categorySet;
	
	public BankAccountImpl() {
		this.objectivesSet 	= new LinkedHashSet<>();
		this.categorySet 	= new LinkedHashSet<>();
	}
	
	@Override
	public void newObjective(String name, int amount) throws PresentElementException {
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
		// TODO Auto-generated method stub
		
	}

}
