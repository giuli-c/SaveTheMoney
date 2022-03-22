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
		this.expenseButton 		= new ExpenseButton("<html>EXPENSE<br /> MANAGEMENT</html>");
		this.paymentsButton 	= new PaymentsButton("<html>PAYMENT<br /> SERVICES</html>");
		this.savingsPlanButton 	= new SavingButton("<html>SAVING<br /> PLAIN<html>");
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); 
		setLayout(new GridLayout(2, 2, 20, 50));
		
		add(depositButton);
		add(expenseButton);
		add(paymentsButton);
		add(savingsPlanButton);
	}
}
