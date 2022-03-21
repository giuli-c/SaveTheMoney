package it.savethemoney.view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

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
		this.expenseButton 		= new ExpenseButton("EXPENSE\n " + "MANAGEMENT");
		this.paymentsButton 	= new PaymentsButton("SERVICE\n PAYMENTS");
		this.savingsPlanButton 	= new SavingButton("SAVING\n PLAN");
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		setLayout(new GridLayout(2, 2, 20, 50));
		
		add(depositButton);
		add(expenseButton);
		add(paymentsButton);
		add(savingsPlanButton);
	}
}
