package it.savethemoney.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BankAccountLabelPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// creo etichette da inserire nel pannello
	private JLabel nameLabel;
	private JLabel balanceLabel;
		
	public BankAccountLabelPanel(String name, double totalBalance) {
		this.nameLabel 		= new BankAccountNameLabel(name);
		this.balanceLabel 	= new BankAccountBalanceLabel(totalBalance);
			
		setLayout(new BorderLayout());
		
		add(nameLabel, BorderLayout.PAGE_START);
		add(balanceLabel, BorderLayout.PAGE_END);
	}
}
