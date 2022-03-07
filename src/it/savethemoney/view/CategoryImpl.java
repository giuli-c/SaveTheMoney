package it.savethemoney.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.savethemoney.model.AbstractData;
import it.savethemoney.model.Category;
import it.savethemoney.model.Expense;

public class CategoryImpl extends AbstractData implements Category {

	private List<Expense> expenseList;
	
	public CategoryImpl(final String nameData) {
		super(nameData);
		this.expenseList = new LinkedList<>();
	}

	@Override
	public List<Expense> expenseCategory() {
		return Collections.unmodifiableList(this.expenseList);		//quando torna la lista, non sarà modificabile
	}																// è impo per garantire la privacy dei dati

	@Override
	public void addExpense(Expense e) {
		this.expenseList.add(e);
	}

	@Override
	public void removeExpense(Expense e) {
		this.expenseList.remove(e);
	}
	
	@Override
	public void modifyData(String newName) {
		super.modifyData(newName);
	}

}
