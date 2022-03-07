package it.savethemoney.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;
import it.savethemoney.model.Objectives;
import it.savethemoney.view.CategoryImpl;
import it.savethemoney.view.ExpenseImpl;
import it.savethemoney.view.ObjectivesImpl;

public class UserImpl implements User {

	private Set<Objectives> objectivesSet;
	private Set<Category> categorySet;
	
	public UserImpl() {
		this.objectivesSet 	= new LinkedHashSet<>();
		this.categorySet 	= new LinkedHashSet<>();
	}
	
	@Override
	public void newObjective(String name, int amount) {
		this.objectivesSet.add(new ObjectivesImpl(name, amount));
	}

	@Override
	public void removeObjective(Objectives o) {
		this.objectivesSet.remove(o);
	}

	@Override
	public void newCategory(String name) {
		this.categorySet.add(new CategoryImpl(name));
	}

	@Override
	public void removeCategory(Category c) {
		this.categorySet.remove(c);
	}

	@Override
	public void addExpense(String name, String date, double amount, Category c) {
		this.categorySet.stream()
						.filter(cat -> cat.equals(c))
						.findFirst()
						.get()
						.addExpense(new ExpenseImpl(name, date, amount));
	}

	@Override
	public void removeExpense(Category c, Expense e) {
		this.categorySet.stream()
		.filter(cat -> cat.equals(c))
		.findFirst()
		.get()
		.removeExpense(e);
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

}
