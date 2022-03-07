package it.savethemoney.implementation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(expenseList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryImpl other = (CategoryImpl) obj;
		return Objects.equals(expenseList, other.expenseList);
	}
	
	

}
