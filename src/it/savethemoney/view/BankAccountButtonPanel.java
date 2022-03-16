package it.savethemoney.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BankAccountButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton depositButton;
	private JButton expenseButton;
	private JButton paymentsButton;
	private JButton savingsPlanButton;
	
	public BankAccountButtonPanel() {
		this.depositButton 		= new DepositButton("DEPOSIT");
		this.expenseButton 		= new ExpenseButton("EXPENSE MANAGEMENT");
		this.paymentsButton 	= new PaymentsButton("SERVICE PAYMENTS");
		this.savingsPlanButton 	= new SavingButton("SAVING PLAN");
		
		setLayout(new GridLayout(2,2,50, 50));
		
		add(depositButton);
		add(expenseButton);
		add(paymentsButton);
		add(savingsPlanButton);
	}
}
