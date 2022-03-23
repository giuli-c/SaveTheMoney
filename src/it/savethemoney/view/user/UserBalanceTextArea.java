package it.savethemoney.view.user;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

public class UserBalanceTextArea extends JTextArea{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserBalanceTextArea(String amount) {
		super(amount);
		
		setPreferredSize(new Dimension(100, 30));
		setFont(new Font("Cambria", Font.ITALIC, 11));
	}
}
