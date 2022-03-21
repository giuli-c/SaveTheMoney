package it.savethemoney.view;

import javax.swing.BorderFactory;
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
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		setPreferredSize(new Dimension(0, 20));
		setFont(new Font("Cambria", Font.ITALIC, 20));
	}
}
