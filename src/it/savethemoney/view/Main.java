package it.savethemoney.view;

import it.savethemoney.view.risparmio.DepositFrame;
import it.savethemoney.view.spese.ExpenseFrame;

public class Main {
	public static void main(String[] args) {
		
		new BankAccountFrame("BankAccount", "Giulia..", 10000);
		new DepositFrame("Deposite");
		new ExpenseFrame("Expense Management");
	}
}
