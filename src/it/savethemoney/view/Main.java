package it.savethemoney.view;

import it.savethemoney.view.pagamenti.PaymentFrame;
import it.savethemoney.view.risparmio.DepositFrame;
import it.savethemoney.view.spese.ExpenseFrame;
import it.savethemoney.view.user.UserFrame;

public class Main {
	public static void main(String[] args) {
		
		// sistemare nome utente da passare e importo da passare;
		new UserFrame("Welcome", " ", " ");
		new BankAccountFrame("BankAccount", "Giulia..", 10000);
		new DepositFrame("Deposite");
		new ExpenseFrame("Expense Management");
		new PaymentFrame("Payment Service");
	}
}
