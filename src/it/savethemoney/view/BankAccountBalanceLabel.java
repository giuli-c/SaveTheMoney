package it.savethemoney.view;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

public class BankAccountBalanceLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountBalanceLabel(double totalBalance) {
		super("Tot. Balance: " + totalBalance);
		
		setPreferredSize(new Dimension(0, 100));
		setFont(new Font("Cambria", Font.ITALIC, 20));
	}
}
